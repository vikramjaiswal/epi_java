public class SuccessorInBinaryTree {

    public SuccessorInBinaryTree() {
    }

    public static BTNodePP successsor(BTNodePP node) {

	BTNodePP curr = node;

	if (curr.right != null) {

	    curr = curr.right;

	    while (curr.left != null)
		curr = curr.left;

	    return curr;

	} else {
	    while (curr.parent != null) {

		if (curr.parent.left == curr)
		    return curr.parent;

		curr = curr.parent;
	    }
	}

	return null;
    }

    public static void main(String[] args) {
	BTNodePP root = BTNodePP.getBinaryTreePg73();

	BTNodePP succ = null;

	succ = successsor(root);

	assert (succ.value.equals("2J"));

	succ = successsor(root.right.right.right);

	assert (succ == null);

	succ = successsor(root.left.left.left);

	assert (succ.value.equals("271C"));

	succ = successsor(root.right.left);

	assert (succ.value.equals("401L"));
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
