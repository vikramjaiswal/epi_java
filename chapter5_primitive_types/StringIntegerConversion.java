public class StringIntegerConversion
{
    
    public static String intToString(int x)
    {
        boolean negative = false;
        
        if (x < 0)
        {
            negative = true;
            x *= -1;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (x != 0)
        {
            int m = x % 10;
            
            sb.insert(0, m);
            
            x /= 10;
        }
        
        if (sb.length() == 0)
            sb.insert(0, '0');
        
        if (negative)
            sb.insert(0, '-');
        
        return sb.toString();
    }
    
    public static int stringToInt(String s)
    {
        
        if (s.equals("-"))
            throw new IllegalArgumentException("illegal input");
        
        boolean negative = false;
        
        if (s.startsWith("-"))
            negative = true;

        
        int x = 0;
        
        for (int i = (negative ? 1 : 0); i < s.length(); i++)
        {
            
            x *= 10;
            
            if (Character.isDigit(s.charAt(i)))
            {
                x = x + Character.getNumericValue(s.charAt(i));
                
            } else
            {
                throw new IllegalArgumentException(
                        "input contains non digit characters input=" + s);
            }
        }
        
        if (negative)
            x *= -1;
        
        return x;
    }
    
    
    public static void main(String[] args)
    {
        log(intToString(345));
        log(intToString(0));
        log(intToString(-346));
        log(intToString(-0));
        
        log(stringToInt("34555555"));
        log(stringToInt("0"));
        log(stringToInt("-346"));
        log(stringToInt("-0"));
        log(stringToInt("345rt"));
        log(stringToInt("-"));
        
        // Integer.parseInt(s)
        // Integer.valueOf(s)
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
