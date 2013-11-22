public class DutchNationalFlag
{
    public static void dutchNationalFlag(int[] a, int i)
    {
        exchange(a, 0, i);
        
        int j = 0;
        
        int lo = 0;
        int hi = a.length - 1;
        
        int lt = lo;
        int gt = hi;
        
        int v = a[0];
        
        while (j <= gt)
        {
            if (a[j] < v)
            {
                exchange(a, j, lt);
                
                lt++;
                j++;
                
            } else if (a[j] > v)
            {
                exchange(a, j, gt--);
                
            } else if (a[j] == v)
            {
                j++;
            }
        }
    }
    
    private static void exchange(int[] a, int i, int j)
    {
        
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void main(String[] args)
    {
        int [] a = new int [] {5, 2, 8, 5, 4, 7, 5, 3};
        
        dutchNationalFlag(a , 0);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
