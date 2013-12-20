public class Array2DSearch {

    public Array2DSearch() {
    }
    
    
    public static boolean search (int[][] a, int x){
	
	int n = a[0].length;
	int r = 0;
	int c = n-1;
	
	log ("(r,c)=("+r + ","+c +")");
	
	while (r >=0 && r < n && c >=0 && c < n){
	    
	    if (x == a[r][c])
		return true;
	    else if  (x > a[r][c])
		r++;
	    else
		c--;
	    
	    
	    log ("(r,c)=("+r + ","+c +")");
	}
	
	
	
	return false;
    }
    

    public static void main(String[] args) {
	
	int [][] a = new int [][] {
		   {0,  2, 4,   6,  8, 10 },
		   {1, 12, 14, 16, 18, 20 },
		   {3, 13, 22, 24, 26, 28 },
		   {5, 15, 23, 34, 36, 38 },
		   {7, 17, 25, 35, 42, 44 },				   
		   {9, 19, 27, 37, 43, 45 }
		   };
	
	log (search(a, 25));
	log (search(a, 11));
	
    }
    
    private static void log(Object object) {
	System.out.println(object);
    }
    
    

}
