import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueUsingPriorityQueue<Item> {

    private class MyComparator implements Comparator<PQObject> {

	@Override
	public int compare(PQObject o1, PQObject o2) {

	    if (o1.index > o2.index)
		return 1;
	    else if (o1.index < o2.index)
		return -1;

	    return 0;
	}
    }

    private class PQObject {

	long index;
	Item value;

	PQObject(long index, Item value) {

	    this.index = index;
	    this.value = value;
	}

	@Override
	public String toString() {
	    return "PQObject [index=" + index + ", vlaue=" + value + "]";
	}
    }

    PriorityQueue<PQObject> minPQ;

    long index;

    public QueueUsingPriorityQueue() {

	minPQ = new PriorityQueue<PQObject>(10, new MyComparator());

	index = Long.MIN_VALUE;
    }

    public Item head() {

	return minPQ.peek().value;
    }

    public void enqueue(Item item) {

	minPQ.add(new PQObject(index++, item));
    }

    public Item dequeue() {

	return minPQ.remove().value;
    }

    public static void main(String[] args) {

	QueueUsingPriorityQueue<Integer> q = new QueueUsingPriorityQueue<Integer>();

	q.enqueue(1);
	q.enqueue(2);
	q.enqueue(3);
	log(q.head());

	q.enqueue(4);
	q.enqueue(5);
	log(q.dequeue());
	log(q.dequeue());
	log(q.dequeue());

	q.enqueue(6);

	log(q.dequeue());
	log(q.dequeue());
	log(q.dequeue());
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
