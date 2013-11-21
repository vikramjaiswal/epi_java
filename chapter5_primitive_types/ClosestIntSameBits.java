import java.util.Random;

public class ClosestIntSameBits
{
    
    public static long getClosestIntSameBits(long x)
    {
        for (int i = 0; i < 63; ++i)
        {
            // if i and i+1 bit are different 
            if ((((x >> i) & 1) ^ ((x >> (i + 1)) & 1)) != 0)
            {
                x ^= (1L << i) | (1L << (i + 1)); // swaps bit-i and bit-(i + 1)
                
                return x;
            }
        }
        
        throw (new IllegalArgumentException("all bits are 0 or 1"));
    }
    
    private static int countBitsSetTo1(long x)
    {
        int count = 0;
        
        while (x > 0)
        {
            x &= (x - 1);
            
            count++;
        }
        
        return count;
    }
    
    private static long getRandom()
    {
        long seed = System.currentTimeMillis();
        
        Random random = new Random(seed);
        
        return random.nextLong();
    }
    
    public static void main(String[] args)
    {
        long x;
        
        if (args.length == 1)
        {
            x = Long.parseLong(args[0]);
        } else
        {
            x = getRandom();
        }
        
        try
        {
            long r = getClosestIntSameBits(x);
            
            log("x=" + x + " :" + Long.toBinaryString(x));
            log("r=" + r + " :" + Long.toBinaryString(r));
            
            assert (countBitsSetTo1(x) == countBitsSetTo1(r));
            
        } catch (IllegalArgumentException e)
        {
            
            log("x=" + x + " :" + Long.toBinaryString(x));
            log(e.getMessage());
        }
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
