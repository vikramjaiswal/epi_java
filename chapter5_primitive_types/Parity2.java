public class Parity2
{
    public static int parity2(long x)
    {
        int result = 0;
        
        while (x > 0)
        {
           result ^=  1;
            
           x = x & (x-1);
        }
        
        return result;
    }
    

    public static void main(String[] args)
    {
        long a = Long.parseLong("101110", 2);
        
        log("a=" + a);
        log(Long.toBinaryString(a));
        
        log("parity=" + parity2(a));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
