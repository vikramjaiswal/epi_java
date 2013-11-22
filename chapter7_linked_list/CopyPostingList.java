public class CopyPostingList
{
    
    public CopyPostingList()
    {
    }
    
    
    public static PostingNode  copyPostingList(PostingNode lh) {
        
        PostingNode l = lh;
        PostingNode lh1 = null;
        
        //Stage1
        lh1 = new PostingNode(l.value, null);
        PostingNode l1 = lh1;
        
        while (l.next != null){
            l = l.next;
            l1.next = new PostingNode(l.value, null);
            l1 = l1.next;
        }
        
        //log (lh1);
        
        l = lh;
        l1 = lh1;
        
        PostingNode t;
        PostingNode t1;
        
        while (l != null){
            
            t = l.next;
            t1 = l1.next;
            
            l.next = l1;
            l1.next = t;
            
            l = t;
            l1 = t1;
        }
        
        //log (lh);
        
        //Stage 2
        l = lh;
        l1 = lh1;
        
        while (l1.next != null){
            
            l1.jump = l.jump.next;
            l = l.next.next;
            l1= l1.next.next;

        }
        
        l1.jump = l.jump.next;
        
        //Stage 3
        l = lh;
        l1 = lh1;
        
        while (l1.next != null){
            
            t = l.next.next;
            t1 = l1.next.next;
            
            l.next = t;
            l1.next = t1;
            
            l = l.next;
            l1 = l1.next;
        }
        
        l.next = null;
        
        //log ("lh :"+lh);
        //log ("lh1:"+ lh1);
                
        return lh1;         
    }
    
    public static void main(String[] args)
    {
        
        PostingNode<String> l = new PostingNode<String>("a", null); 
        l.next = new PostingNode<String>("b", null); 
        l.next.next = new PostingNode<String>("c", null);
        l.next.next.next = new PostingNode<String>("d", null);
        
        l.jump = l.next.next; // a.jump = c 
        l.next.jump = l.next.next.next; // b.jump = d
        l.next.next.jump = l.next; // c.jump = b
        l.next.next.next.jump = l.next.next.next; // d.jump = d
        
        log ("original :"+l);
        
        PostingNode<String> l1 =  copyPostingList(l);
        
        log ("original2:"+l);
        log ("copy     :"+l1);
    }
    
    
    private static void log(Object object)
    {
        System.out.println(object);
    }

    
}
