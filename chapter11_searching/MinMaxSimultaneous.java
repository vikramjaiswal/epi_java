public class MinMaxSimultaneous {

    private static class Pair {

	int lo;
	int hi;

	Pair(int lo, int hi) {
	    this.lo = lo;
	    this.hi = hi;
	}
	
	@Override
	public String toString() {
	    return "Pair [lo=" + lo + ", hi=" + hi + "]";
	}
    }

    public MinMaxSimultaneous() {
    }

    public static Pair getMinMax(int[] a) {
	
	if (a.length == 1)
	    return new Pair (a[0], a[0]);
	
	Pair currentLoHi = getPair(a[0], a[1]);
	
	for (int i = 2; (i+1) < a.length; i=i+2){
	    
	    Pair curr = getPair(a[i], a[i+1]);
	    
	    currentLoHi.lo = Math.min(currentLoHi.lo, curr.lo);
	    currentLoHi.hi = Math.max(currentLoHi.hi, curr.hi);
	}
	
	
	if (a.length % 2 ==1) {
	    currentLoHi.lo = Math.min(currentLoHi.lo, a[a.length-1]);
	    currentLoHi.hi = Math.max(currentLoHi.hi, a[a.length-1]);
	}
	    
	return currentLoHi;   
    }

    private static Pair getPair(int a, int b) {

	if (a < b) {

	    return new Pair(a, b);
	}

	return new Pair(b, a);
    }

    public static void main(String[] args) {
	
	int [] a = new int [] {-4, 2, 6, 7, 8, 9, 10, 5, 1, 100 };
	
	log (getMinMax(a));
	
	int [] b = new int [] {4, 2, 6, 7, 800, -5, 9, 10, 5, 1, 100 };	
	
	log (getMinMax(b));
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
