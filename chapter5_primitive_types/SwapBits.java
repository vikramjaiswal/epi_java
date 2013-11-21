public class SwapBits
{
    public static long swapBits(long x, int i, int j)
    {
        if (((x >> i) & 1) != ((x >> j) & 1))
        {
            x ^= ((1L << i) | (1L << j));
        }
        
        return x;
    }
    
    public static void main(String[] args)
    {
        //long x = Long.parseLong("10000100101", 2);
        long x = Long.parseLong("0110000000000000000001110000000000001000010000000000100001000000", 2);
        
        log("x =" + Long.toBinaryString(x));
        
        long sw = swapBits(x, 61, 60);
        
        log("sw=" + Long.toBinaryString(sw));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
