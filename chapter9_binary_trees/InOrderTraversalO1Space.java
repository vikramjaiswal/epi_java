public class InOrderTraversalO1Space {

    public InOrderTraversalO1Space() {
    }

    public static void inOrderTraversal(BTNodePP root) {

	BTNodePP prev = null;
	BTNodePP curr = root;
	BTNodePP next = null;

	while (curr != null) {

	    if (prev == null || prev.left == curr || prev.right == curr) {

		if (curr.left != null) {

		    next = curr.left;
		} else {

		    log(curr.value);

		    if (curr.right != null)
			next = curr.right;
		    else
			next = curr.parent;
		}

	    } else if (curr.left == prev) {

		log(curr.value);

		if (curr.right != null)
		    next = curr.right;
		else
		    next = curr.parent;

	    } else { // curr.right == prev

		next = curr.parent;
	    }

	    prev = curr;
	    curr = next;
	}

    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub

	BTNodePP root = BTNodePP.getBinaryTreePg73();

	inOrderTraversal(root);
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
