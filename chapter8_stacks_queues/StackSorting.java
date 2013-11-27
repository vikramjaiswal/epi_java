public class StackSorting {

    public StackSorting() {
    }

    private static void sort(MyStack<Integer> st) {
	if (st.isEmpty())
	    return;

	int top = st.pop();

	sort(st);

	insertInOrder(st, top);

    }

    public static void insertInOrder(MyStack<Integer> st, int m) {
	if (st.isEmpty() || st.peek() <= m) {
	    st.push(m);
	} else {
	    int ctop = st.pop();

	    insertInOrder(st, m);

	    st.push(ctop);
	}
    }

    public static void main(String[] args) {
	MyStack<Integer> st = new MyStack<Integer>();

	st.push(10);
	st.push(0);
	st.push(6);
	st.push(3);
	st.push(1);
	st.push(4);
	st.push(4);
	st.push(5);
	st.push(8);

	log(st);

	sort(st);

	log(st);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
