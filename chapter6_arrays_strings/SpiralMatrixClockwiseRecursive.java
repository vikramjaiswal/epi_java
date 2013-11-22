public class SpiralMatrixClockwiseRecursive
{
    
    public static void spiralMatrixClockwise(int[][] a)
    {
        assert (a.length == a[0].length);
        
        int n = a.length;
        
        spiralMatrixClockwise(a, 0, 0, n);
    }
    
    public static void spiralMatrixClockwise(int[][] a, int r, int c, int sz)
    {
        log(" ");
        
        if (sz == 0)
            return;
        
        if (sz == 1)
        {
            log(a[r][c]);
            return;
        }
        
        for (int i = 0; i < sz; i++)
        {
            log(a[r][c++]);
            
        }
        
        c--;
        r++;
        
        for (int i = 0; i < (sz - 1); i++)
        {
            log(a[r++][c]);
        }
        
        r--;
        c--;
        
        for (int i = 0; i < (sz - 1); i++)
        {
            log(a[r][c--]);
        }
        
        c++;
        r--;
        
        for (int i = 0; i < (sz - 2); i++)
        {
            log(a[r--][c]);
        }
        
        r++;
        c++;
        
        
        spiralMatrixClockwise(a, r, c, sz - 2);
    }
    
    public static void main(String[] args)
    {
        /*
        int[][] mult = new int[][] {
                { 1, 2 },
                { 3, 4 } 
                };
        */
        
        
         /*
         int[][] mult = new int[][]{ 
                 { 1, 2, 3}, 
                 { 4, 5, 6}, 
                 { 7, 8, 9} 
                 };*/
        
        int[][] mult = new int[][]{ 
                { 1, 2, 3, 4}, 
                { 5, 6, 7, 8}, 
                { 9, 10, 11, 12},
                { 13, 14, 15, 16}
                };
        
        /*
        int[][] mult = new int[][]{ 
                { 1, 2, 3, 4, 5}, 
                { 6, 7, 8, 9, 10}, 
                { 11, 12, 13, 14, 15},
                { 16, 17, 18, 19, 20},
                { 21, 22, 23, 24, 25},
                };*/
        
        
        spiralMatrixClockwise(mult);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
