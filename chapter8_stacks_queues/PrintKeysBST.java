public class PrintKeysBST {
    private static class BSTNode {
	int key;
	Object value;
	BSTNode left;
	BSTNode right;

	BSTNode(int key) {
	    this.key = key;
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("key=" + key);
	    if (left != null)
		sb.append("left=SET");
	    else
		sb.append("left=null");

	    if (right != null)
		sb.append("right=SET");
	    else
		sb.append("right=null");

	    return sb.toString();
	}
    }

    public PrintKeysBST() {
    }

    public static void printBST(BSTNode root) {
	BSTNode curr = root;
	MyStack<BSTNode> st = new MyStack<BSTNode>();

	while (!st.isEmpty() || curr != null) {
	    if (curr != null) {
		st.push(curr);
		curr = curr.left;
	    } else {
		curr = st.pop();
		log(curr.key);
		curr = curr.right;
	    }
	}

    }

    public static void main(String[] args) {
	BSTNode n43 = new BSTNode(43);

	BSTNode n23 = new BSTNode(23);
	BSTNode n37 = new BSTNode(37);

	BSTNode n29 = new BSTNode(29);
	BSTNode n41 = new BSTNode(41);

	BSTNode n31 = new BSTNode(31);

	BSTNode n47 = new BSTNode(47);

	BSTNode n53 = new BSTNode(53);

	n43.left = n23;
	n43.right = n47;

	n23.right = n37;

	n37.left = n29;
	n37.right = n41;

	n29.right = n31;

	n47.right = n53;

	printBST(n43);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
