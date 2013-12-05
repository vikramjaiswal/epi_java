public class LCABinTree {

    public LCABinTree() {

    }

    public static BTNode findLCA(BTNode n, BTNode a, BTNode b) {

	if (n == null) {
	    return null;

	} else if (n == a || n == b) {
	    return n;
	}

	BTNode l_res = findLCA(n.left, a, b);
	BTNode r_res = findLCA(n.right, a, b);

	if (l_res != null && r_res != null) {
	    
	    return n;
	} else {

	    if (l_res != null)
		return l_res;
	    else // r_res != null 
		return r_res;
	}

    }

    public static void main(String[] args) {

	BTNode root = BTNode.getBinaryTreePg73();

	BTNode a = root.right.left.right.left.right; // 641M
	BTNode b = root.right.right.right; // 28P
	BTNode lca = findLCA(root, a, b);

	assert (lca.value.equals("6I"));

	a = root.right.left.right.left.right; // 641M
	b = root.left; // 6B
	lca = findLCA(root, a, b);

	assert (lca.value.equals("314A"));

    }

}
