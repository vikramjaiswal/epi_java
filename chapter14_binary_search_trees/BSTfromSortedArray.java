public class BSTfromSortedArray {

    public static BSTNode bstfromSortedArray(int [] a) {
    
	BST<Integer, Integer> bst = new BST<Integer, Integer>();
	
	formBST(bst, a, 0, a.length-1);
	
	return bst.root;
    }
    
    
    
    private static void formBST(BST<Integer, Integer> bst, int [] a, int lo, int hi ){
	
	if (hi < lo)
	    return;
	
	int mid = lo + (hi - lo)/2;
	
	bst.put(a[mid], a[mid]);
	
	formBST(bst, a, lo, mid-1);
	formBST(bst, a, mid+1, hi);
    }
    
    
    

    public static void main(String[] args) {
	
	int [] a = new int [] {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	
	BSTNode.printBSTLevelOrder(bstfromSortedArray(a));
	

    }
    
    private static void log(Object object) {
	System.out.println(object);
    }
    
    

}
