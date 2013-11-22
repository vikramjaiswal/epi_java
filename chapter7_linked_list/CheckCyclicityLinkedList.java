public class CheckCyclicityLinkedList
{
    
    public CheckCyclicityLinkedList()
    {
    }
    
    
    
    public static Node checkCyclicity(Node head){
        
        Node slow = head;
        Node fast = head;
        
        
        while ( fast != null && fast.next != null   ) {
            
            slow = slow.next;
            
            fast = fast.next.next;
            
            if (fast == slow)
               break;
        }
        
        
        if (fast == null || fast.next == null)
            return null;
        
        
        slow = head;
        
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
        
    }
    
    
    public static void main(String[] args)
    {
        
        Node<Integer> h = new Node<Integer>(1, null);
        
        h.next = new Node<Integer>(2, null);
        
        h.next.next = new Node<Integer>(3, null);
        
        h.next.next.next = new Node<Integer>(4, null);
        
        h.next.next.next.next = new Node<Integer>(5, null);
        
        h.next.next.next.next.next = new Node<Integer>(6, null);
        
        h.next.next.next.next.next.next = new Node<Integer>(7, null);
        
       // h.next.next.next.next.next.next.next = new Node<Integer>(8, null);
        
        Node tail = h.next.next.next.next.next.next;
        
        log (h.toFullString());
        
       // log (checkCyclicity (h));
        
        Node cyclestart0 = h.next.next; 
        
        tail.next = cyclestart0;
        
        log ( h.next.next.toString());
        
        Node cyclestart = checkCyclicity(h);
        
        log ( cyclestart.toString());
        
        assert (cyclestart0 == cyclestart);
    }
    
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
