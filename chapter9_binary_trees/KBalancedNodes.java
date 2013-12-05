public class KBalancedNodes {
    private static class Pair {
	BTNode node;
	int nodeNum;

	Pair(BTNode node, int nodeNum) {
	    this.node = node;
	    this.nodeNum = nodeNum;
	}
    }

    public static Pair findNonKBalancedNodeHelper(BTNode n, int k) {
	// Empty tree.
	if (n == null) {
	    return new Pair(null, 0);
	}

	// Early return if left subtree is not k-balanced.
	Pair l = findNonKBalancedNodeHelper(n.left, k);
	if (l.node != null) {
	    return l;
	}

	// Early return if right subtree is not k-balanced.
	Pair r = findNonKBalancedNodeHelper(n.right, k);
	if (r.node != null) {
	    return r;
	}

	int nodeNum = l.nodeNum + r.nodeNum + 1; // # of nodes in n.

	if (Math.abs(l.nodeNum - r.nodeNum) > k) {
	    return new Pair(n, nodeNum);
	}

	return new Pair(null, nodeNum);
    }

    public static void main(String[] args) {
	test1();
	test2();
    }

    private static void log(Object object) {
	System.out.println(object);
    }

    private static void test1() {
	// 3
	// 2 5
	// 1 4 6

	BTNode root = new BTNode("3");

	root.left = new BTNode("2");

	root.left.left = new BTNode("1");

	root.right = new BTNode("5");

	root.right.left = new BTNode("4");

	root.right.right = new BTNode("6");

	int k = 0;

	Pair ans = findNonKBalancedNodeHelper(root, k);

	assert (ans.nodeNum == 2);

	if (ans.node != null) {
	    log(ans.node);
	    log(ans.nodeNum);
	}
    }

    private static void test2() {

	BTNode root = BTNode.getBinaryTreePg73();

	Pair ans = findNonKBalancedNodeHelper(root, 3);

	assert (ans.nodeNum == 5);

	if (ans.node != null) {
	    log(ans.node);
	    log(ans.nodeNum);
	}

    }

}
