public class BalancedBinaryTree {

    public BalancedBinaryTree() {

    }

    /*
    public static boolean isBanalced(BTNode node) {
	if (node == null)
	    return true;

	int d = Math.abs(height(node.left) - height(node.right));

	if (d > 1)
	    return false;
	else
	    return isBanalced(node.left) && isBanalced(node.right);
    }

    private static int height(BTNode node) {
	if (node == null)
	    return 0;

	int h = 1 + Math.max(height(node.left), height(node.right));

	return h;
    }*/

    private static int height(BTNode node) {
	if (node == null)
	    return -1;

	int lh = height(node.left);

	if (lh == -2)
	    return -2;

	int rh = height(node.right);

	if (rh == -2)
	    return -2;

	if (Math.abs(lh - rh) > 1)
	    return -2;

	int h = 1 + Math.max(height(node.left), height(node.right));

	return h;
    }

    public static boolean isBanalced(BTNode node) {
	return height(node) != -2;
    }

    public static void main(String[] args) {
	BTNode bt = BTNode.getBinaryTreePg73();
	// BTNode bt = BTNode.getBinaryTreeBalanced();

	log(height(bt));
	log(isBanalced(bt));
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
