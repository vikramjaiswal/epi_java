public class ReverseAllWords
{
    
    public static String reverse (String str){
        
        StringBuilder sb = new StringBuilder(str);
        
        //sb.reverse();
        reverse(sb, 0, sb.length()-1);
        
        
        int sindex = 0;
        int eindex = 0;
        
        
        while (eindex < sb.length()) {
            
            char c = sb.charAt(eindex++);
            
            if (c == ' '){
                // reverse word
                reverse(sb, sindex, eindex-2);
                
                sindex = eindex;
            }
        }
        
        
        reverse(sb, sindex, eindex-1);
        
        return sb.toString();
    }
    
    
    
    private static void reverse(StringBuilder sb, int s, int e){
        
        while (s < e){
            
            char t = sb.charAt(s);
            sb.replace(s, s+1, Character.toString(sb.charAt(e)));;
            sb.replace(e, e+1, Character.toString(t));;
            
            s++;
            e--;
        }
    }
    
    
    
    public static void main(String[] args)
    {
        
        log (reverse("Bob likes Alice and xyz"));
        
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
    
}
