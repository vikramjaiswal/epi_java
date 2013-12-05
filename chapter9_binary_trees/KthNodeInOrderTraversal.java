public class KthNodeInOrderTraversal {

    public KthNodeInOrderTraversal() {
    }

    public static BTNodeSz getKthNodeInOrder(BTNodeSz n, int k) {
	if (n == null)
	    return n;

	if (size(n.left) >= k) {
	    return getKthNodeInOrder(n.left, k);

	} else if ((size(n.left) + 1) == k) {
	    return n;

	} else {
	    return getKthNodeInOrder(n.right, k - (size(n.left) + 1));
	}
    }

    private static int size(BTNodeSz node) {
	return node != null ? node.size : 0;
    }

    public static void main(String[] args) {
	BTNodeSz root = BTNodeSz.getBinaryTreePg73();

	BTNodeSz kthNode = null;

	kthNode = getKthNodeInOrder(root, 1);
	assert (kthNode.value == 28);

	kthNode = getKthNodeInOrder(root, 4);
	assert (kthNode.value == 6);

	kthNode = getKthNodeInOrder(root, 7);
	assert (kthNode.value == 3);

	kthNode = getKthNodeInOrder(root, 10);
	assert (kthNode.value == 401);

	kthNode = getKthNodeInOrder(root, 15);
	assert (kthNode.value == 271);

	kthNode = getKthNodeInOrder(root, 16);
	assert (kthNode.value == 28);

	kthNode = getKthNodeInOrder(root, 17);
	assert (kthNode == null);
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
