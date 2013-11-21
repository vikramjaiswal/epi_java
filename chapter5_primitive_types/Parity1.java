public class Parity1
{
    
    public static int parity1(long x)
    {
        int result = 0;
        
        while (x > 0)
        {
           result ^= (x & 1);
            
            x = x >>> 1;
        }
        
        return result;
    }
    

    public static void main(String[] args)
    {
        long a = Long.parseLong("1011011111", 2);
        
        log("a=" + a);
        log(Long.toBinaryString(a));
        
        log("parity=" + parity1(a));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
