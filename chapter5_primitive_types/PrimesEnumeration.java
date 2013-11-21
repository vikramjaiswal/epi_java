import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimesEnumeration
{
    
    public static List<Integer> primes(int n)
    {
        assert (n >= 2);
        
        List<Integer> list = new ArrayList<Integer>();
        
        boolean[] a = new boolean[n + 1];
        Arrays.fill(a, true);
        
        a[0] = false;
        a[1] = false;
        
        for (int i = 2; i <= n; i++)
        {            
            if (a[i])
            {
                list.add(i);
                
                for (int j = i * i; j <= n; j += i)
                {                   
                    a[j] = false;
                }                
            }
        }
        
        return list;
    }
    
    public static void main(String[] args)
    {
        for (int i : primes(100))
        {
            log(i);
        }
        
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
