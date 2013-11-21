public class ConvertBase
{
    
    public static String convertBase(final String s, int b1, int b2)
    {
        boolean negative = s.startsWith("-");
        
        // step 1 - convert to base 10
        int x = 0;
        
        for (int i = (negative ? 1 : 0); i < s.length(); ++i)
        {
            x = x * b1;
            
            if (Character.isDigit(s.charAt(i)))
            {
                x = x + (Character.getNumericValue(s.charAt(i)));
            } else
            {
                x = x + (s.charAt(i) - 'A' + 10);
            }
        }
        
        // step 2 - convert to base b2
        StringBuilder ans = new StringBuilder();
        
        while (x != 0)
        {
            int r = x % b2;
            
            if (r >= 10)
            {
                char[] carr = Character.toChars('A' + r - 10);
                
                ans.insert(0, carr[0]);
            } else
            {
                ans.insert(0, r);
            }
            
            x /= b2;
        }
        
        if (ans.length() == 0)
        {
            ans.insert(0, '0');
        }
        
        if (negative)
        {
            ans.insert(0, '-');
        }
        
        return ans.toString();
    }
    
    public static void main(String[] args)
    {
        log(convertBase("10", 2, 10)); // 2
        log(convertBase("69", 10, 8)); // 105
        log(convertBase("105", 8, 10)); // 69
        log(convertBase("255", 10, 16)); // FF
        log(convertBase("FF", 16, 10)); // 255
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
