public class BigNumberMultiplication
{
    
    public static int multiply(String str1, String str2)
    {
        
        String a, b;
        
        boolean str1positive = true;
        boolean str2positive = true;
        
        if (str1.startsWith("+"))
        {
            a = str1.substring(1);
        } else if (str1.startsWith("-"))
        {
            str1positive = false;
            a = str1.substring(1);
        } else
        {
            a = str1;
        }
        
        if (str2.startsWith("+"))
        {
            b = str2.substring(1);
        } else if (str2.startsWith("-"))
        {
            str2positive = false;
            b = str2.substring(1);
        } else
        {
            b = str2;
        }
        
        int[] result = new int[a.length() + b.length()];
        
        int sigDigit = 0;
        
        for (int i = b.length() - 1; i >= 0; i--)
        {
            int x = Character.getNumericValue(b.charAt(i));
            
            process(a, x, sigDigit, result);
            
            sigDigit++;
        }
        
        int answer = 0;
        int pow = 0;
        
        for (int i = 0; i < result.length; i++)
        {
            answer += (result[i] * Math.pow(10, pow++));
        }
        
        if (!str1positive)
            answer = answer * -1;
        
        if (!str2positive)
            answer = answer * -1;
        
        return answer;
    }
    
    private static void process(String a, int x, int sigDigit, int[] result)
    {
        
        int sIndex = sigDigit;
        
        int carry = 0;
        
        for (int i = a.length() - 1; i >= 0; i--)
        {
            
            int y = Character.getNumericValue(a.charAt(i));
            
            int p = x * y + carry;
            
            p = p + result[sigDigit];
            
            carry = p / 10;
            
            int r = p % 10;
            
            result[sigDigit] = r;
            
            sigDigit++;
        }
        
        result[sigDigit] = carry;
        
    }
    
    public static void main(String[] args)
    {
        String a = "999999";
        String b = "999";        
        
        int p = multiply(a, b);
        
        log("p="+p);
        
        //int q = 0;
        
        int q = Integer.parseInt(a) * Integer.parseInt(b);
        
        log("q="+q);
        
        assert (p==q);
        
        
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
