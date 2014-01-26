public class BuildBSTDoublyLinkedList {

    public static BSTNode<Integer, String> buildBSTDoublyLinkedList(BSTNode<Integer, String> head) {

	BSTNode<Integer, String> root = build(head);
	
	BSTNode.printBSTLevelOrder(root);
	
	return root;
    }
    
    
    
    public static BSTNode<Integer, String> build(BSTNode<Integer, String> llhead) {
	
	if (llhead == null)
	    return null;
	
	BSTNode<Integer, String> slow = llhead;
	BSTNode<Integer, String> fast = llhead;
	
	while (true){
	    
	    if (fast.right == null)
		break;
	    
	    fast = fast.right; 
	    
	    if (fast.right == null)
		break;
	    
	    fast = fast.right; 
	    
	    slow = slow.right;
	}
	
	
	
	BSTNode<Integer, String> mid = slow;
	
	if (mid != llhead) {
	  
	  slow.left.right = null;
	  mid.left = build(llhead);
	  mid.right= build(mid.right);
	  
	} else{
	    
	  mid.left = build(null);
	  mid.right= build(mid.right);
	}	  
	
	return mid;
    }
    
    
    
    

    public static void main(String[] args) {
	
	BSTNode<Integer, String> head = ConvertBSTDoublyLinkedList.getTestDoublyLinkedList();
	
	log ("---------------------------------");
	
	
	BSTNode<Integer, String> pointer = head;

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

	
	log ("---------------------------------");
	
	
	BSTNode<Integer, String> root = buildBSTDoublyLinkedList(head);
	
	log ("---------------------------------");
	
	inOrderTraversal(root);

    }
    
    public static void inOrderTraversal(BSTNode<Integer, String> node) {

	if (node == null)
	    return;

	inOrderTraversal(node.left);

	log(node.key + "," + node.value);
	
	inOrderTraversal(node.right);
    }
    
    
    
    private static void log(Object object) {
	System.out.println(object);
    }


}
