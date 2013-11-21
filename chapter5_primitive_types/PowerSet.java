import java.util.ArrayList;
import java.util.List;

public class PowerSet
{
    
    public static void powerSet(List<Object> list)
    {
        
        for (int i = 0; i < (1 << list.size()); i++)
        {
            int x = i;
            
            print("{");
            
            while (x > 0)
            {
                int y = x & ~(x - 1); // get x with LSB set all else zeros
                
                int listIndex = log2(y);
                
                if (x != i)
                    print(",");
                
                print(list.get(listIndex));
                
                x &= (x - 1); // drop the LSB
            }
            
            print("}\n");
        }
    }
    
    private static int log2(int x)
    {
        int r = (int) (Math.log(x) / Math.log(2));
        
        return r;
    }
    
    private static void print(Object object)
    {
        System.out.print(object);
    }
    
    public static void main(String[] args)
    {
        int n = 5; // n = 1-52
        
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        List<Object> list = new ArrayList<Object>();
        
        for (int i = 0; i < n; i++)
        {
            list.add(alphabets.substring(i, i + 1));
        }
        
        powerSet(list);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
