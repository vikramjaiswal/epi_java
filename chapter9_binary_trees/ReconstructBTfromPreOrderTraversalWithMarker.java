import java.util.ArrayList;
import java.util.List;

public class ReconstructBTfromPreOrderTraversalWithMarker {

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

    public ReconstructBTfromPreOrderTraversalWithMarker() {
    }

    public static BTreeNode reconstruct(final List<String> list, final int[] ci) {

	if (ci[0] >= list.size())
	    return null;

	if (list.get(ci[0]) == null)
	    return null;

	BTreeNode node = new BTreeNode(list.get(ci[0]));

	ci[0]++;

	node.left = reconstruct(list, ci);

	ci[0]++;

	node.right = reconstruct(list, ci);

	return node;
    }

    public static void main(String[] args) {

	ArrayList<String> list = new ArrayList<String>();

	list.add("H");
	list.add("B");
	list.add("F");
	list.add(null);
	list.add(null);
	list.add("E");
	list.add("A");
	list.add(null);
	list.add(null);
	list.add(null);
	list.add("C");
	list.add(null);
	list.add("D");
	list.add(null);
	list.add("G");
	list.add("I");
	list.add(null);
	list.add(null);
	list.add(null);

	BTreeNode root = reconstruct(list, new int[] { 0 });

	preOrderTraversal(root);
    }

    private static void log(Object object) {
	System.out.print(object);
    }

    public static void preOrderTraversal(BTreeNode node) {
	if (node != null) {
	    log(node.value + ", ");
	    preOrderTraversal(node.left);
	    preOrderTraversal(node.right);
	}
    }

}
