public class ReverseBits
{
    private char[] precomputed;
    
    public ReverseBits()
    {
        precomputed = new char[1 << 16];
        
        for (int i = 0; i < 1 << 16; i++)
        {
            precomputed[i] = reverse16Bits((char) i);
        }
    }
    
    private static char reverse16Bits(char y)
    {
        int x = y;
        int rx = 0;
        
        int count =0;
        
        while (x > 0)
        {
            int lsb = x & 1; // extract LSB
            x = x >>> 1; // drop LSB
            rx = (rx << 1) | lsb;
            count++;
        }
        
        //pad the right most 16 bits with 0s
        while (count < 16){
            rx = (rx << 1);
            count++;
        }
        
        return (char) rx;
    }
    
    public long reverseBits(long y)
    {
        long rev3 = precomputed [(int)(y >>> 48)];
        long rev2 = precomputed [(int)(  (y << 16) >>> 48 )];
        long rev1 = precomputed [(int)(  (y << 32) >>> 48 )];
        long rev0 = precomputed [(int)(  (y << 48) >>> 48 )];

        y = (rev0 << 48) | (rev1 << 32) | (rev2 << 16) | rev3;    
        
        return y;
    }
    
    public static void main(String[] args)
    {
        ReverseBits rb = new ReverseBits();
        
        //long x = Long.parseLong("10000100100111", 2);

        //long x = Long.parseLong("100000000000011100001110000011111000100001011111000100001000011", 2);
        ///////////////////////////xxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzaaaaaaaaaaaaaaaa

        //long x = Long.parseLong("100000000000011100001110000011111000100001011111000100001000011", 2);
        /////////////////////////xxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzaaaaaaaaaaaaaaaa        
        
        //long x = Long.parseLong("1000100001000011", 2);
        /////////////////////////aaaaaaaaaaaaaaaa        
        
        long x = Long.parseLong("100001110000011111000100001011111000100001000011", 2);
        /////////////////////////xxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzaaaaaaaaaaaaaaaa        

        
        log("x =" + Long.toBinaryString(x));
        
        long rx = rb.reverseBits(x);
        
        log("rx=" + Long.toBinaryString(rx));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
