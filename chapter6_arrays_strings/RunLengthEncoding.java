public class RunLengthEncoding
{
    
    public static String encode(String str)
    {
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        
        char prev = str.charAt(index++);
        int prevCount = 1;
        
        char curr;
        
        while (index < str.length())
        {
            curr = str.charAt(index++);
            
            if (prev != curr)
            {
                sb.append(prevCount);
                sb.append(prev);
                prevCount = 0;
            }
            
            prev = curr;
            prevCount++;
        }
        
        sb.append(prevCount);
        sb.append(prev);
        
        return sb.toString();
    }
    
    public static String decode(String str)
    {
        StringBuilder sb = new StringBuilder();
        
        int index = 0;
        int count;
        char curr;
        
        while (index < str.length())
        {
            count = Character.getNumericValue(str.charAt(index++)) ;
            curr = str.charAt(index++);
            
            sb.append(curr);
            
            for (int i = 1; i < count; i++)
            {
                sb.append(curr);
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args)
    {
        log(encode("aaaabcccaa"));
        log(encode("abcccc"));
        
        log(decode("4a1b3c2a"));
        log(decode("1a1b4c"));

        log(decode("3e4f2e"));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
