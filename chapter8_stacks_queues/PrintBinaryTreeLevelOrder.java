public class PrintBinaryTreeLevelOrder {
    private static class BTNode {
	int value;
	BTNode left;
	BTNode right;

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

		log(n.value + " ");
		countProcessed++;

		if (n.left != null)
		    q.enqueue(n.left);

		if (n.right != null)
		    q.enqueue(n.right);
	    }

	    log("\n");
	}

    }

    public static void main(String[] args) {
	BTNode n314A = new BTNode(314);

	BTNode n6B = new BTNode(6);
	BTNode n6I = new BTNode(6);

	BTNode n271C = new BTNode(271);
	BTNode n561F = new BTNode(561);
	BTNode n2J = new BTNode(2);
	BTNode n271O = new BTNode(271);

	BTNode n28D = new BTNode(28);
	BTNode n0E = new BTNode(0);
	BTNode n3G = new BTNode(3);
	BTNode n1K = new BTNode(1);
	BTNode n28P = new BTNode(28);

	BTNode n17H = new BTNode(17);
	BTNode n401L = new BTNode(401);
	BTNode n257N = new BTNode(257);

	BTNode n641M = new BTNode(641);

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

	printBTLevelOrder(n314A);

    }

    private static void log(Object object) {
	System.out.print(object);
    }

}
