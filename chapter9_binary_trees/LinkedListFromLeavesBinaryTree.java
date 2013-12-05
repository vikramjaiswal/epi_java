
import java.util.LinkedList;

public class LinkedListFromLeavesBinaryTree {

    public LinkedListFromLeavesBinaryTree() {
    }

    public static LinkedList<BTNode> linkedListFromLeavesBinaryTree(BTNode root) {

	LinkedList<BTNode> ll = new LinkedList<BTNode>();

	preOrderTraversal(root, ll);

	return ll;
    }

    private static void preOrderTraversal(BTNode node, LinkedList<BTNode> ll) {

	if (node != null) {

	    if (node.left == null && node.right == null)
		ll.add(node);

	    preOrderTraversal(node.left, ll);
	    preOrderTraversal(node.right, ll);
	}

    }

    public static void main(String[] args) {
	
	BTNode root = BTNode.getBinaryTreePg73();

	LinkedList<BTNode> ll = linkedListFromLeavesBinaryTree(root);
	
	for (BTNode n : ll){
	    log (n.value +", ");
	}

    }

    private static void log(Object object) {
	System.out.print(object);
    }

}
