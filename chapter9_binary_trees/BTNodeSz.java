public class BTNodeSz {
    protected int value;

    protected BTNodeSz left;
    protected BTNodeSz right;

    protected int size;

    BTNodeSz(int value) {
	this.value = value;
    }

    public static void main(String[] args) {

    }

    public static BTNodeSz getBinaryTreePg73() {
	BTNodeSz n314A = new BTNodeSz(314);

	BTNodeSz root = n314A;

	BTNodeSz n6B = new BTNodeSz(6);
	BTNodeSz n6I = new BTNodeSz(6);

	BTNodeSz n271C = new BTNodeSz(271);
	BTNodeSz n561F = new BTNodeSz(561);
	BTNodeSz n2J = new BTNodeSz(2);
	BTNodeSz n271O = new BTNodeSz(271);

	BTNodeSz n28D = new BTNodeSz(28);
	BTNodeSz n0E = new BTNodeSz(0);
	BTNodeSz n3G = new BTNodeSz(3);
	BTNodeSz n1K = new BTNodeSz(1);
	BTNodeSz n28P = new BTNodeSz(28);

	BTNodeSz n17H = new BTNodeSz(17);
	BTNodeSz n401L = new BTNodeSz(401);
	BTNodeSz n257N = new BTNodeSz(257);

	BTNodeSz n641M = new BTNodeSz(641);

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

	// //////////////////

	n314A.size = 16;

	n6B.size = 7;
	n6I.size = 8;

	n271C.size = 3;
	n561F.size = 3;
	n2J.size = 5;
	n271O.size = 2;

	n28D.size = 1;
	n0E.size = 1;
	n3G.size = 2;
	n1K.size = 4;
	n28P.size = 1;

	n17H.size = 1;
	n401L.size = 2;
	n257N.size = 1;

	n641M.size = 1;

	return root;
    }

}
