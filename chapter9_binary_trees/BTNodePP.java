public class BTNodePP {
    protected String value;
    protected BTNodePP parent;
    protected BTNodePP left;
    protected BTNodePP right;

    BTNodePP(String value) {
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

    }

    public static BTNodePP getBinaryTreePg73() {
	BTNodePP n314A = new BTNodePP("314A");

	BTNodePP root = n314A;

	BTNodePP n6B = new BTNodePP("6B");
	BTNodePP n6I = new BTNodePP("6I");

	BTNodePP n271C = new BTNodePP("271C");
	BTNodePP n561F = new BTNodePP("561F");
	BTNodePP n2J = new BTNodePP("2J");
	BTNodePP n271O = new BTNodePP("271O");

	BTNodePP n28D = new BTNodePP("28D");
	BTNodePP n0E = new BTNodePP("0E");
	BTNodePP n3G = new BTNodePP("3G");
	BTNodePP n1K = new BTNodePP("1K");
	BTNodePP n28P = new BTNodePP("28P");

	BTNodePP n17H = new BTNodePP("17H");
	BTNodePP n401L = new BTNodePP("401L");
	BTNodePP n257N = new BTNodePP("257N");

	BTNodePP n641M = new BTNodePP("641M");

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

	// /////////////
	n6B.parent = n314A;
	n6I.parent = n314A;

	n271C.parent = n6B;
	n561F.parent = n6B;
	n2J.parent = n6I;
	n271O.parent = n6I;

	n28D.parent = n271C;
	n0E.parent = n271C;
	n3G.parent = n561F;
	n1K.parent = n2J;
	n28P.parent = n271O;

	n17H.parent = n3G;
	n401L.parent = n1K;
	n257N.parent = n1K;

	n641M.parent = n401L;

	return root;
    }

}
