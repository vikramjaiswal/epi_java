import java.util.Comparator;
import java.util.PriorityQueue;

public class StackUsingPriorityQueue<Item> {

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

    public StackUsingPriorityQueue() {

	minPQ = new PriorityQueue<PQObject>(10, new MyComparator());

	index = Long.MAX_VALUE;
    }

    public Item peek() {

	return minPQ.peek().value;
    }

    public void push(Item item) {

	minPQ.add(new PQObject(index--, item));
    }

    public Item pop() {

	return minPQ.remove().value;
    }

    public static void main(String[] args) {

	StackUsingPriorityQueue<Integer> st = new StackUsingPriorityQueue<Integer>();

	st.push(1);
	st.push(2);
	st.push(3);
	log(st.peek());

	st.push(4);
	st.push(5);
	log(st.pop());
	log(st.pop());
	log(st.pop());
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
