public class ConvertBSTDoublyLinkedList {

    private static BSTNode<Integer, String> b = new BSTNode(0, "B", 0);
    private static BSTNode<Integer, String> prev = null;
    private static BSTNode<Integer, String> curr = null;

    public static BSTNode<Integer, String> convertBSTDoublyLinkedList(
	    BSTNode<Integer, String> root) {

	b = new BSTNode(0, "B", 0);
	prev = null;
	curr = null;

	inOrderTraversal(root);

	return b.right;
    }

    public static void inOrderTraversal(BSTNode<Integer, String> node) {

	if (node == null)
	    return;

	inOrderTraversal(node.left);

	curr = node;

	if (b.right == null) {
	    b.right = curr;
	} else {
	    prev.right = curr;
	    curr.left = prev;
	}

	prev = curr;

	inOrderTraversal(node.right);
    }

    public static void main(String[] args) {

	BSTNode<Integer, String> root = BST.getBSTRoot();

	log("-------------------------------------------");

	BSTNode<Integer, String> pointer = convertBSTDoublyLinkedList(root);

	while (pointer.right != null) {

	    log(pointer.key + "," + pointer.value);
	    pointer = pointer.right;
	}

	log(pointer.key + "," + pointer.value);

	log("-------------------------------------------");

	while (pointer.left != null) {

	    log(pointer.key + "," + pointer.value);
	    pointer = pointer.left;
	}

	log(pointer.key + "," + pointer.value);

    }
    

    public static BSTNode<Integer, String> getTestDoublyLinkedList() {
	
	BSTNode<Integer, String> root = BST.getBSTRoot();
	
	BSTNode<Integer, String> head = convertBSTDoublyLinkedList(root);
	
	return head;
    }
    

    private static void log(Object object) {
	System.out.println(object);
    }

}
