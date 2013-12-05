public class LCABinTreeParentPointer {

    public LCABinTreeParentPointer() {
    }

    public static BTNodePP findLCA(BTNodePP n1, BTNodePP n2) {
	
	int d1 = distance(n1);
	int d2 = distance(n2);

	BTNodePP nL = null;
	BTNodePP nH = null;
	int dL = 0;
	int dH = 0;

	int delta = Math.abs(d1 - d2);

	if (d1 < d2) {
	    dL = d1;
	    nL = n1;
	    dH = d2;
	    nH = n2;
	} else {
	    dL = d2;
	    nL = n2;
	    dH = d1;
	    nH = n1;
	}

	while (delta > 0) {

	    nH = nH.parent;
	    delta--;
	}

	while (nH.parent != null && nL.parent != null) {

	    if (nH == nL)
		return nH;

	    nL = nL.parent;
	    nH = nH.parent;
	}
	
        if (nH == nL)
	  return nH;
        else
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

	BTNodePP n1 = root.right.left.right.left.right; //641M
	BTNodePP n2 = root.right.right.right; //28P
	BTNodePP lca = findLCA(n1, n2);

	assert (lca.value.equals("6I"));
	
	n1 = root.right.left.right.left.right; //641M
	n2 = root.left; // 6B
	lca = findLCA(n1, n2);
	
	assert (lca.value.equals("314A"));
	
	
	
    }

}
