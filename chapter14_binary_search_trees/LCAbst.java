public class LCAbst {

    public LCAbst() {
    }

    public static BSTNode<Integer, String> findLCA(
	    BSTNode<Integer, String> node, Integer lo, Integer hi) {

	assert (lo <= hi);

	while (node != null) {

	    if (lo < node.key && hi < node.key) {
		node = node.left;
	    } else if (lo > node.key && hi > node.key) {
		node = node.right;
	    } else if (lo <= node.key && hi >= node.key) {
		return node;
	    }

	}

	return null;
    }

    public static void main(String[] args) {

	BSTNode<Integer, String> root = BST.getBST1();

	log(findLCA(root, 2, 5));

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
