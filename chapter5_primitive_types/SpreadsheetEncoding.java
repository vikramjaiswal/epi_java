public class SpreadsheetEncoding
{
    
    public static int ssDecodeColID(String code)
    {
        int decode = 0;
        
        for (int i = 0; i < code.length(); i++)
        {
            decode *= 26;
            decode += (code.charAt(i) - 'A' + 1);
        }
        
        return decode;
    }
    
    public static void main(String[] args)
    {
        log(ssDecodeColID("A"));
        log(ssDecodeColID("B"));
        log(ssDecodeColID("Z"));
        log(ssDecodeColID("AA"));
        log(ssDecodeColID("ZZ"));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
