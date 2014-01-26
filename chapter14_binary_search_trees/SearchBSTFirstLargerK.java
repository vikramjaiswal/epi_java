public class SearchBSTFirstLargerK {

    public SearchBSTFirstLargerK() {
    }

    public static BSTNode<Integer, String> findFirstLargerK(
	    BSTNode<Integer, String> node, Integer key) {

	BSTNode<Integer, String> lastParentWithLeftChild = null;

	BSTNode<Integer, String> current = node;

	while (current != null) {

	    int cmp = key.compareTo(current.key);

	    if (cmp < 0) {

		lastParentWithLeftChild = current;
		current = current.left;

	    } else if (cmp > 0) {

		current = current.right;

	    } else {

		if (current.right != null)
		    return findMin(current.right);
		else
		    return lastParentWithLeftChild;

	    }
	}

	return null;
    }

    public static BSTNode findMin(BSTNode node) {

	if (node.left == null)
	    return node;

	return findMin(node.left);
    }

    public static void main(String[] args) {

	BSTNode<Integer, String> root = BST.getBST1();

	log(findFirstLargerK(root, 11));
	log(findFirstLargerK(root, 53));
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
