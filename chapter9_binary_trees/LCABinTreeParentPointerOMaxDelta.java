import java.util.HashSet;
import java.util.Set;

public class LCABinTreeParentPointerOMaxDelta {

    public LCABinTreeParentPointerOMaxDelta() {
    }

    public static BTNodePP findLCA(BTNodePP n1, BTNodePP n2) {

	Set<BTNodePP> set = new HashSet<BTNodePP>();

	while (n1.parent != null || n2.parent != null) {

	    if (n1.parent != null) {

		if (set.contains(n1))
		    return n1;

		set.add(n1);
		n1 = n1.parent;

	    }

	    if (n2.parent != null) {

		if (set.contains(n2))
		    return n2;

		set.add(n2);
		n2 = n2.parent;

	    }

	}

	if (set.contains(n1))
	    return n1;

	set.add(n1);

	if (set.contains(n2))
	    return n2;

	set.add(n2);

	return null;
    }

    private static int distance(BTNodePP n) {

	int d = 0;

	while (n.parent != null) {

	    n = n.parent;
	    d++;
	}

	return d;
    }

    public static void main(String[] args) {

	BTNodePP root = BTNodePP.getBinaryTreePg73();

	BTNodePP n1 = root.right.left.right.left.right; // 641M
	BTNodePP n2 = root.right.right.right; // 28P
	BTNodePP lca = findLCA(n1, n2);

	assert (lca.value.equals("6I"));

	n1 = root.right.left.right.left.right; // 641M
	n2 = root.left; // 6B
	lca = findLCA(n1, n2);

	assert (lca.value.equals("314A"));

    }

}
