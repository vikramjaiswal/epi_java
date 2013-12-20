public class BinarySearchAi {

    public BinarySearchAi() {
    }

    public static int searchAi(int[] a) {

	int lo = 0;
	int hi = a.length - 1;

	int mid = -1;

	while (lo <= hi) {

	    mid = lo + (hi - lo) / 2;

	    if (a[mid] > mid) {

		hi = mid - 1;

	    } else if (a[mid] < mid) {

		lo = mid + 1;

	    } else { // a[mid] == mid

		return mid;
	    }
	}

	return -1;
    }

    public static int searchAiDuplicates(int[] a, int lo, int hi) {

	if (lo > hi)
	    return -1;
	
	
	int mid = lo + (hi - lo) / 2;

	if (a[mid] == mid) {
	    
	    return mid;

	} else {

	  
	    int sl = -1;
	    int sr = -1;
	    
	    if (searchPossible(a, lo, mid-1)){
		sl = searchAiDuplicates(a, lo, mid-1);
	    }
	    
	    if (sl == -1 && (searchPossible(a, mid+1, hi))){
		
		sr = searchAiDuplicates(a, mid+1, hi);
	    }
	    
	    
	    if (sl != -1)
		return sl;

	    if (sr != -1)
		return sr;
	    
	    return -1;
	} 	
	
    }
    
    
    
    private static boolean searchPossible(int[] a, int lo, int hi) {
	
	if (lo > hi)
	   return false;

	int loValue = a[lo];
	int hiValue = a[hi];
	
	if(loValue <= hi && hiValue >= lo)
	    return true;
	
	return false;
    }

    public static void main(String[] args) {
	testSearchAi();
	testSearchAiDuplicates();
    }
    
    
    private static void testSearchAi(){
	
	int a[] = new int[] { -14, -10, 2, 108, 109, 243, 285, 286, 287, 401 };

	log(searchAi(a));
	assert (searchAi(a) == 2);

	a = new int[] { -14, -10, 3, 108, 109, 243, 285, 286, 287, 401 };
	log(searchAi(a));
	assert (searchAi(a) == -1);

	a = new int[] { -1, 0, 1, 2, 3, 4, 5, 6, 7, 9 };
	log(searchAi(a));
	assert (searchAi(a) == 9);

	a = new int[] { 0, 2, 3, 4, 5, 6, 7, 9, 10, 11 };
	log(searchAi(a));
	assert (searchAi(a) == 0);
    }
    
    
    private static void testSearchAiDuplicates(){
	int a[] = new int[] { 1, 1, 1, 108, 109, 243, 285, 286, 287, 401 };
	/*
	log(searchAiDuplicates(a, 0, a.length-1));
	assert (searchAiDuplicates(a, 0, a.length-1) == 1);
		
	a = new int[] { -3, -2, -1, 2, 2, 5, 5, 26, 287, 401 };
	log(searchAiDuplicates(a, 0, a.length-1));
	assert (searchAiDuplicates(a, 0, a.length-1) == 5);
	
	a = new int[] { -3, -2, -1, 2, 2, 2, 5, 26, 287, 401 };
	log(searchAiDuplicates(a, 0, a.length-1));
	assert (searchAiDuplicates(a, 0, a.length-1) == -1);
	*/
	
	a = new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
	log(searchAiDuplicates(a, 0, a.length-1));
	assert (searchAiDuplicates(a, 0, a.length-1) == 9);
	
	
	
    }
    
    

    private static void log(Object object) {
	System.out.println(object);
    }

}
