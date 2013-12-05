public class SymmetricBinaryTree {

    public SymmetricBinaryTree() {
    }

    public static boolean isSymmetric(BTNode root) {
	return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(BTNode ln, BTNode rn) {

	if (ln == null && rn == null) {
	    return true;
	} else if (ln != null && rn != null) {
	    boolean ret = (ln.value == rn.value
		    && isSymmetric(ln.left, rn.right) && isSymmetric(ln.right,
		    rn.left));

	    return ret;
	}

	return false;
    }

    public static void main(String[] args) {
	test1();
	test2();
	test3();
    }

    private static void log(Object object) {
	System.out.println(object);
    }

    private static void test1() {
	BTNode n314A = new BTNode("314");

	BTNode root = n314A;

	BTNode n6B = new BTNode("6");
	BTNode n6E = new BTNode("6");

	BTNode n2C = new BTNode("2");
	BTNode n2F = new BTNode("2");
	BTNode n3D = new BTNode("3");
	BTNode n3G = new BTNode("3");

	n314A.left = n6B;
	n6B.right = n2C;
	n2C.right = n3D;

	n314A.right = n6E;
	n6E.left = n2F;
	n2F.left = n3G;

	boolean b = isSymmetric(root);
	log(b);
	assert (b == true);
    }

    private static void test2() {
	BTNode n314A = new BTNode("314");

	BTNode root = n314A;

	BTNode n6B = new BTNode("6");
	BTNode n6E = new BTNode("6");

	BTNode n2C = new BTNode("561");
	BTNode n2F = new BTNode("2");
	BTNode n3D = new BTNode("3");
	BTNode n3G = new BTNode("3");

	n314A.left = n6B;
	n6B.right = n2C;
	n2C.right = n3D;

	n314A.right = n6E;
	n6E.left = n2F;
	n2F.left = n3G;

	boolean b = isSymmetric(root);
	log(b);
	assert (b == false);
    }

    private static void test3() {
	BTNode n314A = new BTNode("314");

	BTNode root = n314A;

	BTNode n6B = new BTNode("6");
	BTNode n6E = new BTNode("6");

	BTNode n2C = new BTNode("561");
	BTNode n2F = new BTNode("561");
	BTNode n3D = new BTNode("3");

	n314A.left = n6B;
	n6B.right = n2C;
	n2C.right = n3D;

	n314A.right = n6E;
	n6E.left = n2F;

	boolean b = isSymmetric(root);
	log(b);
	assert (b == false);

    }

}
