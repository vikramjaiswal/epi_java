import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EliasGammaCoding
{
    
    public static String encode(int[] a)
    {
        StringBuilder sb = new StringBuilder();
        
        for (int j = 0; j < a.length; j++)
        {
            sb.append(encode(a[j]));
        }
        
        return sb.toString();
    }
    
    private static String encode(int i)
    {
        StringBuilder sb = new StringBuilder();
        
        while (i != 0)
        {
            int m = i % 2;
            
            i = i / 2;
            
            sb.insert(0, m);
        }
        
        int size = sb.length() - 1;
        
        for (int j = 0; j < size; j++)
        {
            sb.insert(0, 0);
        }
        
        return sb.toString();
    }
    
    public static int[] decode(String s)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for (int i = 0; i < s.length();)
        {
            i = getIndexSetDecoded(s, i, list);
        }
        
        int[] a = new int[list.size()];
        
        int i = 0;
        for (int j : list)
        {
            a[i++] = j;
        }
        
        return a;
    }
    
    private static int getIndexSetDecoded(String s, int i, List<Integer> list)
    {
        int countZerosPlus1 = 1;
        
        while (s.charAt(i) == '0')
        {
            countZerosPlus1++;
            i++;
        }
        
        int decoded = 0;
        
        while (countZerosPlus1 != 0)
        {
            decoded += (int) (Character.getNumericValue(s.charAt(i)) * Math
                    .pow(2, countZerosPlus1 - 1));
            
            countZerosPlus1--;
            i++;
        }
        
        list.add(decoded);
        
        return i;
    }
    
    public static void main(String[] args)
    {
        int[] a = new int[] { 5, 7, 13, 35 };
        
        String encoded = encode(a);
        
        int[] b = decode(encoded);
        
        log(encoded);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
}
