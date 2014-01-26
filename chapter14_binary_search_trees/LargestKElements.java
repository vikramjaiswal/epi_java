import java.util.ArrayList;
import java.util.List;

public class LargestKElements {

    public static ArrayList<BSTNode<Integer, String>> largestKElements(
	    BSTNode<Integer, String> root, int k) {

	ArrayList<BSTNode<Integer, String>> list = new ArrayList<BSTNode<Integer, String>>();

	reverseInOrde(root, list, k);

	return list;
    }

    private static void reverseInOrde(BSTNode<Integer, String> node,
	    ArrayList<BSTNode<Integer, String>> list, int k) {

	if (list.size() == k || node == null)
	    return;

	reverseInOrde(node.right, list, k);

	if (list.size() < k) {
	    list.add(node);

	    reverseInOrde(node.left, list, k);
	}

    }

    public static void main(String[] args) {

	BSTNode<Integer, String> root = BST.getBSTRoot();

	ArrayList<BSTNode<Integer, String>> list = largestKElements(root, 3);

	log("---------------------");

	for (BSTNode<Integer, String> node : list) {

	    log(node.key + "," + node.value);
	}

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
