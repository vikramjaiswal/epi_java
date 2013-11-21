public class GCD
{
    
    public static int gcd(int x, int y)
    {
        
        if (x == 0)
        {
            
            return y;
            
        } else if (y == 0)
        {
            
            return x;
            
        } else if (((x & 1) == 0) & ((y & 1) == 0))
        { // if x and y are even
        
            return gcd(x >>> 1, y >>> 1) * 2;
            
        } else if (((x & 1) == 0) & ((y & 1) == 1))
        { // if x is even y is odd
        
            return gcd(x >>> 1, y);
            
        } else if (((x & 1) == 1) & ((y & 1) == 0))
        { // if x is odd y is even
        
            return gcd(x, y >>> 1);
        }
        
        return gcd(Math.max(x, y) - Math.min(x, y), Math.min(x, y));
    }
    
    public static int gcdV0(int x, int y)
    {
        if (x == y)
        {
            return x;
        }
        
        return gcdV0(Math.max(x, y) - Math.min(x, y), Math.min(x, y));
    }
    
    public static int gcdV1(int x, int y)
    {
        
        if (x == 0)
        {
            return y;
        }
        
        if (y == 0)
        {
            return x;
        }
        
        return gcdV1(Math.max(x, y) - Math.min(x, y), Math.min(x, y));
    }
    
    public static int gcdEuclid(int a, int b)
    {
        
        if (b == 0)
            return a;
        
        return gcdEuclid(b, a % b);
    }
    
    public static void main(String[] args)
    {
        // log(gcdModulus(6, 60));
        
        log(gcdV0(60, 55));
        
        // log(gcdV1(60, 60));
        
        // log(gcd(60, 55));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
