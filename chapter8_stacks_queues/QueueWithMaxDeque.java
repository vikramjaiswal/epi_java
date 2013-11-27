import java.util.ArrayDeque;
import java.util.Deque;

public class QueueWithMaxDeque {

    Queue<Integer> q;
    Deque<Integer> deque;

    public QueueWithMaxDeque() {
	q = new Queue<Integer>();
	deque = new ArrayDeque<Integer>();
    }

    public void enqueue(int item) {
	q.enqueue(item);

	while (!deque.isEmpty() && deque.peekLast() < item) {
	    deque.removeLast();
	}

	deque.addLast(item);
    }

    public int dequeue() {
	if (isEmpty())
	    throw new RuntimeException("dequeue called on Empty Queue");

	int r = q.dequeue();

	if (r == deque.peekFirst())
	    deque.removeFirst();

	return r;
    }

    public int max() {
	return deque.peekFirst();
    }

    public int size() {
	return q.size();
    }

    public boolean isEmpty() {
	return q.isEmpty();
    }

    public static void main(String[] args) {
	test1();
	test2();
    }

    private static void test1() {
	QueueWithMaxDeque q = new QueueWithMaxDeque();

	q.enqueue(1);
	q.enqueue(3);
	q.enqueue(2);

	assert (3 == q.max());

	q.enqueue(6);
	q.enqueue(4);
	q.enqueue(5);

	assert (6 == q.max());

	assert (1 == q.dequeue());
	assert (3 == q.dequeue());
	assert (2 == q.dequeue());

	q.enqueue(11);

	assert (11 == q.max());
	q.enqueue(12);
	q.enqueue(13);

	q.enqueue(14); // now the vector (data) is resized; but the head and
		       // tail.
		       // (or elements) does not change accordingly.
	q.enqueue(15);
	q.enqueue(16);

	assert (16 == q.max());

	assert (6 == q.dequeue());
	assert (4 == q.dequeue());
	assert (5 == q.dequeue());
	assert (11 == q.dequeue());
	assert (12 == q.dequeue());
	assert (13 == q.dequeue());
	assert (14 == q.dequeue());
	assert (15 == q.dequeue());
	assert (16 == q.dequeue());

    }

    private static void test2() {
	QueueWithMaxDeque q = new QueueWithMaxDeque();

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
