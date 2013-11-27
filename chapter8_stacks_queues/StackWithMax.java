public class StackWithMax {
    private Node top = null;
    private int size = 0;

    private MNode mtop = null;

    private class Node {

	Integer value;
	Node next;

	Node(Integer value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    private class MNode {

	Integer mvalue;
	MNode mnext;
	int mcount;

	MNode(Integer mvalue, MNode mnext, int mcount) {
	    this.mvalue = mvalue;
	    this.mnext = mnext;
	    this.mcount = mcount;
	}

    }

    public StackWithMax() {
    }

    public boolean isEmpty() {

	return size == 0;
    }

    public int size() {

	return size;
    }

    public void push(Integer value) {

	if (isEmpty()) {

	    Node n = new Node(value, null);
	    size++;
	    top = n;

	    mpush(value);

	    return;
	}

	Node n = new Node(value, top);
	size++;
	top = n;

	mpush(value);
    }

    public Integer pop() {

	if (isEmpty())
	    throw new RuntimeException("Stack Undeflow");

	Node n = top;
	size--;

	top = top.next;

	mpop(n.value);

	return n.value;
    }

    public Integer peek() {

	if (isEmpty())
	    throw new RuntimeException("Stack Underflow");

	return top.value;
    }

    public Integer max() {

	if (isEmpty())
	    throw new RuntimeException("Stack Underflow");

	return mtop.mvalue;
    }

    private void mpush(Integer value) {

	if (mtop == null) {

	    MNode mn = new MNode(value, null, 1);
	    mtop = mn;

	} else if (value > mtop.mvalue) {

	    MNode mn = new MNode(value, mtop, 1);
	    mtop = mn;

	} else if (mtop.mvalue == value) {

	    mtop.mcount++;
	}

    }

    private void mpop(Integer value) {

	if (mtop.mvalue == value) {

	    if (--mtop.mcount == 0) {
		mtop = mtop.mnext;
	    }
	}
    }

    public String toString() {

	StringBuilder sb = new StringBuilder();

	sb.append("----------------------------------------\n");

	sb.append("size=" + size + "\n");

	if (!isEmpty())
	    sb.append("max=" + max() + "\n");

	Node t = top;

	sb.append("main:");

	while (t != null) {

	    sb.append(t.value + "->");

	    t = t.next;
	}

	sb.append(t + "\n");

	MNode mt = mtop;

	sb.append("aux :");

	while (mt != null) {

	    sb.append(mt.mvalue + "," + mt.mcount + "->");

	    mt = mt.mnext;
	}

	sb.append(mt);

	return sb.toString();
    }

    public static void main(String[] args) {
	StackWithMax st = new StackWithMax();
	log(st);

	st.push(2);
	log(st);

	st.push(2);
	log(st);

	st.push(1);
	log(st);

	st.push(4);
	log(st);

	st.push(5);
	log(st);

	st.push(5);
	log(st);

	st.push(3);
	log(st);

	st.pop();
	log(st);

	st.pop();
	log(st);

	st.pop();
	log(st);

	st.pop();
	log(st);

	st.push(0);
	log(st);

	st.push(3);
	log(st);

	st.pop();
	st.pop();
	st.pop();
	st.pop();
	st.pop();
	log(st);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
