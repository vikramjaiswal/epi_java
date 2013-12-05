import java.util.ArrayList;
import java.util.List;

public class ReconstructBTPreInPostInOrderTraversal {

    private static class BTreeNode {
	String value;
	BTreeNode left;
	BTreeNode right;

	BTreeNode(String value) {
	    this.value = value;
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("value=" + value);
	    if (left != null)
		sb.append(" left=SET");
	    else
		sb.append(" left=null");

	    if (right != null)
		sb.append(" right=SET");
	    else
		sb.append(" right=null");

	    return sb.toString();
	}

    }

    public ReconstructBTPreInPostInOrderTraversal() {
    }

    public static BTreeNode reconstructBTPreInOrderTraversal(List<String> pre,
	    int preSt, int preEnd, List<String> in, int inSt, int inEnd) {
	if (preEnd > preSt && inEnd > inSt) {
	    assert ((inEnd - inSt) == (preEnd - preSt));

	    int it = in.indexOf(pre.get(preSt));
	    int leftTreeSize = it - inSt;

	    BTreeNode node = new BTreeNode(pre.get(preSt));

	    node.left = reconstructBTPreInOrderTraversal(pre, preSt + 1, preSt
		    + 1 + leftTreeSize, in, inSt, it);

	    node.right = reconstructBTPreInOrderTraversal(pre, preSt + 1
		    + leftTreeSize, preEnd, in, it + 1, inEnd);

	    return node;
	}

	return null;
    }

    public static BTreeNode reconstructBTPostInOrderTraversal(
	    List<String> post, int postSt, int postEnd, List<String> in,
	    int inSt, int inEnd) {

	if (postEnd > postSt && inEnd > inSt) {
	    assert ((inEnd - inSt) == (postEnd - postSt));

	    int it = in.indexOf(post.get(postEnd - 1));
	    int leftTreeSize = it - inSt;

	    BTreeNode node = new BTreeNode(post.get(postEnd - 1));

	    node.left = reconstructBTPostInOrderTraversal(post, postSt, postSt
		    + leftTreeSize, in, inSt, it);
	    node.right = reconstructBTPostInOrderTraversal(post, postSt
		    + leftTreeSize, postEnd - 1, in, it + 1, inEnd);

	    return node;
	}

	return null;
    }

    public static void main(String[] args) {
	ArrayList<String> in = new ArrayList<String>();
	in.add("F");
	in.add("B");
	in.add("A");
	in.add("E");
	in.add("H");
	in.add("C");
	in.add("D");
	in.add("I");
	in.add("G");

	ArrayList<String> pre = new ArrayList<String>();
	pre.add("H");
	pre.add("B");
	pre.add("F");
	pre.add("E");
	pre.add("A");
	pre.add("C");
	pre.add("D");
	pre.add("G");
	pre.add("I");

	ArrayList<String> post = new ArrayList<String>();
	post.add("F");
	post.add("A");
	post.add("E");
	post.add("B");
	post.add("I");
	post.add("G");
	post.add("D");
	post.add("C");
	post.add("H");

	testReconstructBTPreInOrderTraversal(pre, in);

	testReconstructBTPostInOrderTraversal(post, in);
    }

    private static void testReconstructBTPreInOrderTraversal(List<String> pre,
	    List<String> in) {
	BTreeNode root = reconstructBTPreInOrderTraversal(pre, 0, pre.size(),
		in, 0, in.size());

	log("inOrderTraversal\n");
	inOrderTraversal(root);
	log("\npreOrderTraversal\n");
	preOrderTraversal(root);
	log("\n");
    }

    private static void testReconstructBTPostInOrderTraversal(
	    List<String> post, List<String> in) {
	BTreeNode root = reconstructBTPostInOrderTraversal(post, 0,
		post.size(), in, 0, in.size());

	log("inOrderTraversal\n");
	inOrderTraversal(root);
	log("\npostOrderTraversal\n");
	postOrderTraversal(root);
	log("\n");
    }

    private static void log(Object object) {
	System.out.print(object);
    }

    public static void inOrderTraversal(BTreeNode node) {
	if (node != null) {
	    inOrderTraversal(node.left);
	    log(node.value + ", ");
	    inOrderTraversal(node.right);
	}
    }

    public static void preOrderTraversal(BTreeNode node) {
	if (node != null) {
	    log(node.value + ", ");
	    preOrderTraversal(node.left);
	    preOrderTraversal(node.right);
	}
    }

    public static void postOrderTraversal(BTreeNode node) {
	if (node != null) {
	    postOrderTraversal(node.left);
	    postOrderTraversal(node.right);
	    log(node.value + ", ");
	}
    }

}
