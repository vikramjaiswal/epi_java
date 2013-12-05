import java.util.Iterator;

public class ExteriorBinaryTree {

    public ExteriorBinaryTree() {

    }

    public static Queue<BTNode> getExteriorBinaryTree(BTNode root) {

	Queue<BTNode> q = new Queue<BTNode>();

	if (root != null)
	    q.enqueue(root);

	postOrderTraversal(root.left, q, new int[] { 1 });

	MyStack<BTNode> st = new MyStack<BTNode>();

	mirroePostOrderTraversal(root.right, st, new int[] { 1 });

	while (!st.isEmpty())
	    q.enqueue(st.pop());

	return q;
    }

    private static void postOrderTraversal(BTNode node, Queue<BTNode> q,
	    final int[] state) {

	if (node != null) {

	    if (state[0] == 1) {

		q.enqueue(node);
		if (node.left == null)
		    state[0] = 2;

	    } else if (state[0] == 2) {

		if (node.left == null && node.right == null)
		    q.enqueue(node);
	    }

	    postOrderTraversal(node.left, q, state);
	    postOrderTraversal(node.right, q, state);
	}
    }

    private static void mirroePostOrderTraversal(BTNode node,
	    MyStack<BTNode> st, final int[] state) {

	if (node != null) {

	    if (state[0] == 1) {

		st.push(node);
		if (node.right == null)
		    state[0] = 2;

	    } else if (state[0] == 2) {

		if (node.left == null && node.right == null)
		    st.push(node);
	    }

	    mirroePostOrderTraversal(node.right, st, state);
	    mirroePostOrderTraversal(node.left, st, state);
	}
    }

    public static void main(String[] args) {

	BTNode root = BTNode.getBinaryTreePg73();

	Queue<BTNode> q = getExteriorBinaryTree(root);

	Iterator<BTNode> it = q.iterator();

	while (it.hasNext()) {
	    log(it.next().value + ", ");
	}

    }

    private static void log(Object object) {
	System.out.print(object);
    }

}
