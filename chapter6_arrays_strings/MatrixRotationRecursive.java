public class MatrixRotationRecursive
{
    
    public static void rotateMatrix(int[][] m)
    {
        
        int n = m.length;
        assert (m.length == m[0].length);
        
        rotateMatrix(0, 0, m, n, 0);
        
    }
    
    private static void rotateMatrix(int sr, int sc, int[][] m, int sz, int step)
    {

        if (sz == 0 || sz == 1)
            return;
        
        int temp;
        
        int i = sr;
        int j = sc;
        
        int sz1 = sz - 1;
        
        for (int x = 0; x < sz1; x++)
        {
            
            temp = m[i][j];
            
            m[i][j] = m[sz1 - j + step][i];
            
            m[sz1 - j + step][i] = m[sz1 - i + step][sz1 - j + step];
            
            m[sz1 - i + step][sz1 - j + step] = m[j][sz1 - i + step];
            
            m[j][sz1 - i + step] = temp;
            
            i++;
        }
        
        rotateMatrix(++sr, ++sc, m, sz - 2, step + 2);
    }
    
    public static void main(String[] args)
    {

        /*
        int[][] mult = new int[][] {
                { 1, 2 },
                { 3, 4 } 
                };*/
        
         
         /*
         int[][] mult = new int[][]{ 
                 { 1, 2, 3}, 
                 { 4, 5, 6}, 
                 { 7, 8, 9} 
                 };*/
         
        /*
        int[][] mult = new int[][]{ 
                { 1, 2, 3, 4}, 
                { 5, 6, 7, 8}, 
                { 9, 10, 11, 12},
                { 13, 14, 15, 16}
                };*/
        

        int[][] mult = new int[][]{ 
                { 1, 2, 3, 4, 5}, 
                { 6, 7, 8, 9, 10}, 
                { 11, 12, 13, 14, 15},
                { 16, 17, 18, 19, 20},
                { 21, 22, 23, 24, 25},
                };
        

        log(mult);
        
        rotateMatrix(mult);
        
        log(mult);
    }
    
    private static void log(int[][] m)
    {
        int nrows = m.length;
        int ncols = m[0].length;
        
        for (int r = 0; r < nrows; r++)
        {
            
            System.out.print("|");
            
            for (int c = 0; c < ncols; c++)
            {
                
                System.out.print(m[r][c] + " ");
            }
            
            System.out.print("|\n");
        }
        
        System.out.println("**********************");
        
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
