public class QueueWithMax2Stacks {
    StackWithMax headSt;
    StackWithMax tailSt;

    public QueueWithMax2Stacks() {
	headSt = new StackWithMax();
	tailSt = new StackWithMax();
    }

    public void enqueue(int item) {
	headSt.push(item);
    }

    public int dequeue() {
	if (size() == 0)
	    throw new RuntimeException("dequeue called on an empty Queue");

	if (tailSt.isEmpty()) {
	    while (!headSt.isEmpty())
		tailSt.push(headSt.pop());
	}

	return tailSt.pop();
    }

    public int max() {
	if (headSt.isEmpty() && tailSt.isEmpty())
	    throw new RuntimeException("max() called on an empty Queue");

	if (!headSt.isEmpty() && !tailSt.isEmpty()) {

	    return Math.max(headSt.max(), tailSt.max());
	} else if (!headSt.isEmpty()) {
	    return headSt.max();
	}

	return tailSt.max();
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
	QueueWithMax2Stacks q = new QueueWithMax2Stacks();

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
	QueueWithMax2Stacks q = new QueueWithMax2Stacks();

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
