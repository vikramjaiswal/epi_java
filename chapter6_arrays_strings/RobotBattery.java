public class RobotBattery
{
    
    public int findBatteryCapacity(int [] a){
        
        int maxcap = Integer.MIN_VALUE;
        
        int minsofar = a[0];
        
        for (int i =1; i < a.length; i++){
            
            minsofar = Math.min(minsofar, a[i]);
            
            maxcap = Math.max(maxcap, a[i]- minsofar);
        }
        
        return maxcap;
    }
    
    
    public int findBatteryCapacityBruteForce(int [] a){
        
        int maxcapfound = Integer.MIN_VALUE;
        
        int currentmaxcap = Integer.MIN_VALUE;
        
        int x;
        int y;
        
        for (int i = 1 ; i < a.length; i++){
            
            
            x = i;
            for (int j = i-1; j >=0; j--){
                
                if ((x-j) > currentmaxcap){
                    
                    currentmaxcap = x-j;
                    y = j;
                }
            }
        }
        
        
        
        return -1;
    }
    
    
    
    
    public static void main(String[] args)
    {
        
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
    
    
}
