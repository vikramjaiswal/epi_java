import java.util.ArrayList;
import java.util.List;

public class PowerSetRecurAlternative
{
    
    public static void powerSet(List<Object> list)
    {
        List<Object> prefixList = new ArrayList<Object>();
        
        powerSetHelper(prefixList, list, 0);
    }
    
    private static void powerSetHelper(List<Object> prefixList,
            List<Object> list, int listStIndex)
    {
        boolean firstelement = true;
        
        print("{");
        for (Object o : prefixList)
        {
            if (!firstelement)
                print(",");
            
            print(o);
            
            firstelement = false;
        }
        print("}\n");
        
        for (int i = listStIndex; i < list.size(); i++)
        {
            
            List<Object> prefixList2 = new ArrayList<Object>();
            prefixList2.addAll(prefixList);
            
            prefixList2.add(list.get(i));
            
            powerSetHelper(prefixList2, list, i + 1);
        }
    }
    
    private static void print(Object object)
    {
        System.out.print(object);
    }
    
    public static void main(String[] args)
    {
        int n = 4; // n = 1-52
        
        String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        List<Object> list = new ArrayList<Object>();
        
        for (int i = 0; i < n; i++)
        {
            list.add(alphabets.substring(i, i + 1));
        }
        
        powerSet(list);
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
