public class MyStack<Item> {
    private Node top = null;
    private int size = 0;

    private class Node {

	Item value;
	Node next;

	Node(Item value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    public MyStack() {
    }

    public boolean isEmpty() {

	return size == 0;
    }

    public int size() {

	return size;
    }

    public void push(Item value) {

	if (isEmpty()) {

	    Node n = new Node(value, null);
	    size++;
	    top = n;

	    return;
	}

	Node n = new Node(value, top);
	size++;
	top = n;
    }

    public Item pop() {

	if (isEmpty())
	    throw new RuntimeException("Stack Undeflow");

	Node n = top;
	size--;

	top = top.next;

	return n.value;
    }

    public Item peek() {

	if (isEmpty())
	    throw new RuntimeException("Stack Underflow");

	return top.value;
    }

    public String toString() {

	StringBuilder sb = new StringBuilder();

	sb.append("----------------------------------------\n");
	sb.append("size=" + size + "\n");

	Node t = top;
	sb.append("main:");

	while (t != null) {
	    sb.append(t.value + "->");
	    t = t.next;
	}

	sb.append(t);

	return sb.toString();
    }

    public static void main(String[] args) {
	MyStack st = new MyStack();
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
