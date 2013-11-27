public class QueueUsing2Stacks<Item> {
    MyStack<Item> headSt;
    MyStack<Item> tailSt;

    public QueueUsing2Stacks() {
	headSt = new MyStack<Item>();
	tailSt = new MyStack<Item>();
    }

    public void enqueue(Item item) {
	headSt.push(item);
    }

    public Item dequeue() {
	if (size() == 0)
	    throw new RuntimeException("dequeue called on an empty Queue");

	if (tailSt.isEmpty()) {
	    while (!headSt.isEmpty())
		tailSt.push(headSt.pop());
	}

	return tailSt.pop();
    }

    public int size() {
	return headSt.size() + tailSt.size();
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public static void main(String[] args) {
	test1();
	test2();
    }

    private static void test1() {
	QueueUsing2Stacks<Integer> q = new QueueUsing2Stacks<Integer>();

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

    private static void test2() {
	QueueUsing2Stacks<Integer> q = new QueueUsing2Stacks<Integer>();

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

    private static void log(Object object) {
	System.out.println(object);
    }

}
