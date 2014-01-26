public class BST<Key extends Comparable<Key>, Value> {

    protected BSTNode<Key, Value> root;

    public BST() {
    }

    private int size() {

	if (root == null)
	    return 0;
	else
	    return root.size;
    }

    private int size(BSTNode<Key, Value> node) {

	if (node == null)
	    return 0;
	else
	    return node.size;
    }

    public void put(Key key, Value value) {

	root = put(root, key, value);

	/*
	 * if (root == null){ root = new BSTNode(key, value, -1); } else {
	 * putIterative(root, key, value); }
	 */

    }

    private BSTNode<Key, Value> put(BSTNode<Key, Value> node, Key key,
	    Value value) {

	if (node == null) {
	    node = new BSTNode<Key, Value>(key, value, 1);
	    return node;
	}

	int cmp = key.compareTo(node.key);

	if (cmp < 0)
	    node.left = put(node.left, key, value);
	else if (cmp > 0)
	    node.right = put(node.right, key, value);
	else if (cmp == 0)
	    node.value = value;

	node.size = size(node.left) + size(node.right) + 1;

	return node;

    }

    private void putIterative(BSTNode<Key, Value> root, Key key, Value value) {

	assert (root != null);

	BSTNode<Key, Value> curr = root;

	while (true) {

	    int cmp = key.compareTo(curr.key);

	    if (cmp < 0) {

		if (curr.left != null)
		    curr = curr.left;
		else {
		    curr.left = new BSTNode(key, value, -1);
		    break;
		}

	    } else if (cmp > 0) {

		if (curr.right != null)
		    curr = curr.right;
		else {
		    curr.right = new BSTNode(key, value, -1);
		    break;
		}

	    } else if (cmp == 0) {
		curr.value = value;
		break;
	    }

	}
    }

    public Value get(Key key) {

	// return get(root, key);
	return getIterative(root, key);
    }

    private Value get(BSTNode<Key, Value> node, Key key) {

	if (node == null)
	    return null;

	int cmp = key.compareTo(node.key);

	if (cmp < 0)
	    return get(node.left, key);
	else if (cmp > 0)
	    return get(node.right, key);
	else
	    // cmp == 0
	    return node.value;
    }

    private Value getIterative(BSTNode<Key, Value> node, Key key) {

	while (node != null) {

	    int cmp = key.compareTo(node.key);

	    if (cmp < 0)
		node = node.left;
	    else if (cmp > 0)
		node = node.right;
	    else
		// cmp == 0
		return node.value;
	}

	return null;

    }

    public void delete(Key key) {

	root = delete(root, key);
    }

    private BSTNode<Key, Value> delete(BSTNode<Key, Value> node, Key key) {

	if (node == null)
	    return null;

	int cmp = key.compareTo(node.key);

	if (cmp < 0) {
	    node.left = delete(node.left, key);
	} else if (cmp > 0) {
	    node.right = delete(node.right, key);
	} else { // cmp == 0

	    if (node.left != null && node.right != null) {

		// hibrrad deletion

		BSTNode<Key, Value> sccr = min(node.right);

		node.right = deleteMin(node.right);

		node.key = sccr.key;
		node.value = sccr.value;

	    } else if (node.left == null) {
		return node.right;
	    } else if (node.right == null) {
		return node.left;
	    }

	}

	node.size = size(node.left) + size(node.right) + 1;

	return node;
    }

    private BSTNode<Key, Value> deleteMin(BSTNode<Key, Value> node) {

	assert (node != null);

	if (node.left == null) {

	    return node.right;

	} else {

	    node.left = deleteMin(node.left);

	}

	node.size = size(node.left) + size(node.right) + 1;

	return node;
    }

    private BSTNode<Key, Value> min(BSTNode<Key, Value> node) {

	assert (node != null);

	while (node.left != null)
	    node = node.left;

	return node;
    }

    public static void main(String[] args) {
	
	testDelete();

    }
    
    private static void log(Object object) {
	System.out.println(object);
    }

    
    private static void testDelete(){
	
	BST<Integer, String> bst1 = getBSTTree1();
	bst1.delete(53);
	log("--------------------------------------");
	BSTNode.printBSTLevelOrder(bst1.root);
    }
    
    
    public static BST<Integer, String> getBSTTree1() {
	
	BST<Integer, String> bst = new BST<Integer, String>();

	bst.put(19, "A");
	bst.put(7, "B");
	bst.put(3, "C");
	bst.put(2, "D");
	bst.put(5, "E");

	bst.put(11, "F");
	bst.put(17, "G");
	bst.put(13, "H");

	bst.put(43, "I");
	bst.put(23, "J");
	bst.put(37, "K");

	bst.put(29, "L");
	bst.put(31, "M");
	bst.put(41, "N");

	bst.put(47, "O");
	bst.put(53, "P");
	
	BSTNode.printBSTLevelOrder(bst.root);
	
	return bst;
    }

    public static BSTNode<Integer, String> getBST1() {

	return getBSTTree1().root;
    }
    
    public static BSTNode<Integer, String> getBSTRoot() {

 	return getBSTTree1().root;
    }
     

}
