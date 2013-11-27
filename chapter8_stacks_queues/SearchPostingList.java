public class SearchPostingList {

    public SearchPostingList() {
    }

    public static void searchRecursive(PostingNode p) {

	searchRecursive(p, new Integer[] { 0 });
    }

    private static void searchRecursive(PostingNode p, Integer[] order) {

	if (p != null && p.order == -1) {
	    p.order = order[0]++;

	    searchRecursive(p.jump, order);
	    searchRecursive(p.next, order);
	}
    }

    public static void searchIterative(PostingNode p) {
	MyStack<PostingNode> st = new MyStack<PostingNode>();

	int order = 0;

	PostingNode curr;

	st.push(p);

	while (!st.isEmpty()) {
	    curr = st.pop();

	    if (curr.order == -1) {
		curr.order = order++;

		if (curr.jump != null)
		    st.push(curr.jump);

		if (curr.next != null)
		    st.push(curr.next);
	    }
	}
    }

    public static void main(String[] args) {

	PostingNode<String> l = new PostingNode<String>("a", null);
	l.next = new PostingNode<String>("b", null);
	l.next.next = new PostingNode<String>("c", null);
	l.next.next.next = new PostingNode<String>("d", null);

	/*
	 * l.jump = l.next.next; // a.jump = c l.next.jump = l.next.next.next;
	 * // b.jump = d l.next.next.jump = l.next; // c.jump = b
	 * l.next.next.next.jump = l.next.next.next; // d.jump = d
	 */

	l.jump = l.next.next; // a.jump = c
	// l.next.jump = l.next.next.next; // b.jump = d
	// l.next.next.jump = l.next; // c.jump = b
	l.next.next.jump = l.next.next.next; // c.jump = d
	l.next.next.next.jump = l.next.next.next; // d.jump = d

	log("original   :" + l);

	// searchRecursive(l);
	searchIterative(l);

	log("post search:" + l);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
