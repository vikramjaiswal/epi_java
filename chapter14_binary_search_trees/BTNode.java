public class BTNode {

    protected int value;
    protected BTNode left;
    protected BTNode right;

    BTNode(int value) {
	this.value = value;
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append("value=" + value);
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

    public static void main(String[] args) {
	// printBTLevelOrder(getBinaryTreePg75());

	//printBTLevelOrder(getBinaryTreeBalanced());
    }

    private static void log(Object object) {
	System.out.println(object);
    }

    public static void printBTLevelOrder(BTNode root) {
	Queue<BTNode> q = new Queue<BTNode>();

	q.enqueue(root);
	int countBlock = 0;
	int countProcessed = 0;

	int count = 0;

	while (!q.isEmpty()) {
	    countBlock = q.size();
	    countProcessed = 0;

	    while (countProcessed < countBlock) {
		BTNode n = q.dequeue();

		log1(n.value + " ");
		countProcessed++;

		if (n.left != null)
		    q.enqueue(n.left);

		if (n.right != null)
		    q.enqueue(n.right);
	    }

	    log1("\n");
	}

    }

    private static void log1(Object object) {
	System.out.print(object);
    }

    /*
    public static BTNode getBinaryTreePg73() {
	BTNode n314A =  new BTNode("314A");

	BTNode root = n314A;

	BTNode n6B =    new BTNode("6B");
	BTNode n6I =    new BTNode("6I");

	BTNode n271C =  new BTNode("271C");
	BTNode n561F =  new BTNode("561F");
	BTNode n2J =    new BTNode("2J");
	BTNode n271O =  new BTNode("271O");

	BTNode n28D =   new BTNode("28D");
	BTNode n0E =    new BTNode("0E");
	BTNode n3G =    new BTNode("3G");
	BTNode n1K =    new BTNode("1K");
	BTNode n28P =   new BTNode("28P");

	BTNode n17H =   new BTNode("17H");
	BTNode n401L =  new BTNode("401L");
	BTNode n257N =  new BTNode("257N");

	BTNode n641M =  new BTNode("641M");

	n314A.left = n6B;
	n314A.right = n6I;

	n6B.left = n271C;
	n6B.right = n561F;
	n6I.left = n2J;
	n6I.right = n271O;

	n271C.left = n28D;
	n271C.right = n0E;
	n561F.right = n3G;
	n2J.right = n1K;
	n271O.right = n28P;

	n3G.left = n17H;
	n1K.left = n401L;
	n1K.right = n257N;

	n401L.right = n641M;

	return root;
    }

    public static BTNode getBinaryTreeBalanced() {
	BTNode n314A = new BTNode("314");

	BTNode root = n314A;

	BTNode n6B = new BTNode("6");
	BTNode n6I = new BTNode("6");

	BTNode n271C = new BTNode("271");
	BTNode n561F = new BTNode("561");
	BTNode n2J = new BTNode("2");
	BTNode n271O = new BTNode("271");

	// BTNode n28D = new BTNode(28);
	// BTNode n0E = new BTNode(0);
	// BTNode n3G = new BTNode(3);
	// BTNode n1K = new BTNode(1);
	// BTNode n28P = new BTNode(28);

	// BTNode n17H = new BTNode(17);
	// BTNode n401L = new BTNode(401);
	// BTNode n257N = new BTNode(257);

	// BTNode n641M = new BTNode(641);

	n314A.left = n6B;
	n314A.right = n6I;

	n6B.left = n271C;
	n6B.right = n561F;
	n6I.left = n2J;
	n6I.right = n271O;

	// n271C.left = n28D;
	// n271C.right = n0E;
	// n561F.right = n3G;
	// n2J.right = n1K;
	// n271O.right = n28P;

	// n3G.left = n17H;
	// n1K.left = n401L;
	// n1K.right = n257N;

	// n401L.right = n641M;

	return root;
    }*/

}
