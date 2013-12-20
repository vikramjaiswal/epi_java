import java.util.Random;

public class KthLargestElement {

    public KthLargestElement() {
    }

    private static int partition(int[] a, int lo, int hi) {
	
	if (lo==hi)
	    return lo;
	
	assert (lo < hi);

	int i = lo;
	int j = hi + 1;

	int v = a[lo];

	while (true) {

	    while (v < a[++i])
		if (i == hi)
		    break;

	    while (v > a[--j])
		if (j == lo)
		    break;

	    if (i >= j)
		break;

	    exch(a, i, j);
	}

	exch(a, lo, j);

	return j;
    }

    private static void exch(int[] a, int i, int j) {

	int t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

    public static int kthLargestElement(int a[], int k) {
	
	randomShuffel(a);
	
	int lo = 0;
	int hi = a.length-1;
	
	while (true){
	    
	    int j = partition(a, lo, hi);
	    
	    if (k == j+1){
		
		return a[j];
	    }
	    else if ( (j+1) < k ){
		
		lo = j+1;
		
	    }
	    else if ( (j+1) > k ){
		
		hi = j-1;
	    }
	}
    }

    private static void randomShuffel(int[] a) {

	for (int i = 0; i < a.length; i++) {

	    int r = random(i);

	    exch(a, i, r);
	}
    }

    private static int random(int n) {

	long seed = System.currentTimeMillis();
	Random random = new Random(seed);

	int r = random.nextInt(n + 1);

	return r;
    }

    public static void main(String[] args) {
	
	int a[] = new int[] {1,2,3,4,5,6,7,8,9,10};
	
	log(kthLargestElement(a , 3));
	log(kthLargestElement(a , 1));
	log(kthLargestElement(a , 9));
	log(kthLargestElement(a , 10));
    }
    
    private static void log(Object object) {
	System.out.println(object);
    }
    

}
