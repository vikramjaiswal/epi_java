public class Parity3
{
    private char[]  precomputed_parity;
    
    public Parity3()
    {
        precomputed_parity = new char[1<<16];
        
        for (int i = 0; i < (1<<16); i++)
        {
             precomputed_parity[i] = (char) Parity1.parity1((long) i);
        }
    }
    
    public int parity3(long x)
    {
        int result =  precomputed_parity[ (int) (x >>> 48)] ^  precomputed_parity[(int) ((x << 16) >>> 48)]
                ^  precomputed_parity[(int) ((x << 32) >>> 48)] ^  precomputed_parity[(int) ((x << 48) >>> 48)];
        
        return result;

        /*
        long p = 0;
        
        int result1 = 0;
        int result2 = 0;
        int result3 = 0;
        int result4 = 0;
        
        p = x >>> 48;
        log(Long.toBinaryString(p));
        result1 =  precomputed_parity[(int) p];
        
        p = (x << 16) >>> 48;
        log(Long.toBinaryString(p));        
        result2 =  precomputed_parity[(int) p];
        
        p = (x << 32) >>> 48;
        log(Long.toBinaryString(p));        
        result3 =  precomputed_parity[(int) p];
        
        p = (x << 48) >>> 48;
        log(Long.toBinaryString(p));        
        result3 =  precomputed_parity[(int) p];
        
        //int result = result1 ^ result2 ^ result3 ^ result4;
        */
        
        //return result;
    }
    
    public static void main(String[] args)
    {
        Parity3 parity3 = new Parity3();
        
        long a = Long.parseLong("0100000000000000000001110000000000001000010000000000100001000000", 2);
        /////////////////////////xxxxxxxxxxxxxxxxyyyyyyyyyyyyyyyyzzzzzzzzzzzzzzzzaaaaaaaaaaaaaaaa
        //long a = 4611686018427387904L;
        
        log("a=" + a);
        log(Long.toBinaryString(a));
        
        log("parity1=" + Parity1.parity1(a));
        log("parity2=" + Parity2.parity2(a));
        log("parity3=" + parity3.parity3(a));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
    
}
