public class MatrixRotationNaive
{
    
    public static void rotateMatrix(int [][] m) {
        
        int n = m.length;
        int tmp;
    
        for (int i = 0; i < n/2; i++){
            
            for (int j= i; j < (n-1-i) ; j++){
                tmp = m[i][j];
                
                m[i][j] = m [n-1-j][i];
                
                m [n-1-j][i] = m [n-1-i][n-1-j];
                
                m [n-1-i][n-1-j] = m [j][n-1-i];
                
                m [j][n-1-i] = tmp;
            }
        }
        
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
        
        
        log (mult);
        
        rotateMatrix(mult);
        
        log (mult);
        
    }
    
    
    private static void log(int [][] m)
    {
        int nrows = m.length;
        int ncols = m[0].length;
        
        for (int r=0; r < nrows; r++ ){
            
            System.out.print("|");
            
            for (int c=0; c < ncols; c++ ){
                
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
