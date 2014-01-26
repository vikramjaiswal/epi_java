public class IsBinaryTreeBST {

    public IsBinaryTreeBST() {
    }

    public boolean isBST(BTNode node) {

	return isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST(BTNode node, int lo, int hi) {

	if (node == null)
	    return true;

	if (node.value < lo || node.value > hi) {
	    return false;
	}

	return isBST(node.left, lo, node.value)
		&& isBST(node.right, node.value, hi);
    }

    
    
    
    
    public static void main(String[] args) {

    }

}
