import java.util.HashSet;
import java.util.Set;

public class LazyInit
{
    boolean[] b;
    int[] a;
    
    public LazyInit(int n)
    {       
        b = new boolean[n];
        a = new int[n];
    }
    
    public boolean read(int index, Set<Integer> set)
    {
        if (b[index])
        {
            set.add(a[index]);
            return true;
        }
        
        return false;
    }
    
    public void write(int index, int value)
    {
        
        a[index] = value;
        b[index] = true;
    }
    
    public static void main(String[] args)
    {
        LazyInit li = new LazyInit(5);
        
        Set<Integer> set = new HashSet<Integer>(); 
        
        boolean ans = li.read(0, set);
        
        assert(ans == false);
        
        li.write(3, 11);
        
        set.clear();
        ans = li.read(3, set);
        
        assert(ans == true);
        
        set.clear();
        ans = li.read(4, set);
        assert(ans == false);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
