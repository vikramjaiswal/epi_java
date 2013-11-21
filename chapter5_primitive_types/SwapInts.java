public class SwapInts
{
    
    public static void swapInts(int a, int b)
    {
        log("a=" + a + " b=" + b);
        
        a = a ^ b;
        
        b = a ^ b;
        
        a = a ^ b;
        
        log("a=" + a + " b=" + b);
    }
    
    public static void main(String[] args)
    {
        swapInts(2, 3);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
