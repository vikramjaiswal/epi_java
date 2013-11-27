import java.util.Iterator;

public class Queue<Item> implements Iterable {
    private int s = -1;
    private int e = -1;

    private int size = 0;

    private Item[] arr;

    public Queue() {
	this(1);
    }

    public Queue(int m) {
	arr = (Item[]) new Object[m];

	s = -1;
	e = -1;
	size = 0;
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return size == 0;
    }

    public void enqueue(Item item) {
	if (e == arr.length - 1 && size > arr.length * 3 / 4) {
	    moveDataToFrontResize(arr.length * 2);

	} else if (e == arr.length - 1 && size <= arr.length * 3 / 4) {
	    moveDataToFront();
	}

	if (isEmpty()) {
	    s = 0;
	    e = 0;

	} else {
	    e++;
	}

	size++;

	arr[e] = item;
    }

    public Item dequeue() {
	if (isEmpty())
	    throw new RuntimeException("dequeue called on Empty Queue");

	Item value = arr[s];

	arr[s] = null;

	s++;
	size--;

	if (size == 0) {
	    s = -1;
	    e = -1;
	} else if (size == arr.length / 4) {
	    moveDataToFrontResize(arr.length / 2);
	}

	return value;
    }

    private void moveDataToFront() {
	int i = 0;

	for (; i < size; i++) {
	    arr[i] = arr[s];
	    arr[s++] = null;
	}

	s = 0;
	e = i - 1;
    }

    private void moveDataToFrontResize(int newSize) {
	Item[] tarr = (Item[]) new Object[newSize];
	int i = 0;

	for (; i < size; i++) {
	    tarr[i] = arr[s];
	    arr[s++] = null;
	}

	arr = tarr;

	s = 0;
	e = i - 1;
    }

    public Iterator iterator() {
	return new QueueIterator();
    }

    private class QueueIterator<Item> implements Iterator {
	int si = s;
	int ei = e;

	@Override
	public boolean hasNext() {
	    if (si == -1 || ei == -1 || si > ei) {
		return false;
	    }

	    return true;
	}

	@Override
	public Item next() {
	    return (Item) arr[si++];
	}

	@Override
	public void remove() {
	    throw new RuntimeException("remove() not implemented");
	}
    }

    public String toString() {

	StringBuilder sb = new StringBuilder();

	sb.append("Queue[" + arr.length + "][" + size + "]");
	sb.append("s=" + s + "e=" + e + "{");

	for (int i = 0; i < arr.length; i++) {

	    if (arr[i] == null) {
		sb.append("n");
	    } else {
		sb.append(arr[i]);
	    }

	    if (i != arr.length - 1)
		sb.append(",");
	}

	sb.append("}{");

	Iterator it = iterator();
	boolean first = true;

	while (it.hasNext()) {

	    if (first)
		first = false;
	    else
		sb.append(",");

	    sb.append(it.next());

	}

	sb.append("}");

	return sb.toString();
    }

    public static void main(String[] args) {
	test();

	Queue<Integer> q = new Queue(8);
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	assert (1 == q.dequeue());
	q.enqueue(4);
	assert (2 == q.dequeue());
	assert (3 == q.dequeue());
	assert (4 == q.dequeue());
	try {
	    q.dequeue();
	} catch (RuntimeException rtex) {
	    log(rtex.getMessage());
	}

	// test resize().
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	q.enqueue(4);
	assert (q.size() == 9);

    }

    private static void test() {
	Queue<Integer> q = new Queue(8);
	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	q.enqueue(4);
	q.enqueue(5);
	q.enqueue(6);
	q.enqueue(7);
	q.enqueue(8);
	// Now head = 0 and tail = 0

	assert (1 == q.dequeue());
	assert (2 == q.dequeue());
	assert (3 == q.dequeue());
	// Now head = 3 and tail = 0

	q.enqueue(11);
	q.enqueue(12);
	q.enqueue(13);
	// Ok till here. Now head = 3 and tail = 3

	q.enqueue(14); // now the vector (data) is resized; but the head and
		       // tail.
		       // (or elements) does not change accordingly.
	q.enqueue(15);
	q.enqueue(16);
	q.enqueue(17);
	q.enqueue(18);
	// The elements starting from head=3 are overwriten!

	assert (4 == q.dequeue());
	assert (5 == q.dequeue());
	assert (6 == q.dequeue());
	assert (7 == q.dequeue());
	assert (8 == q.dequeue());
	assert (11 == q.dequeue());
	assert (12 == q.dequeue());
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
