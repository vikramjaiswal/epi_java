public class ZipAList
{
    
    public ZipAList()
    {
    }
    
    public static Node zip(Node h)
    {
        
        Node slow = h;
        Node fast = h;
        
        while (fast.next != null)
        {
            
            fast = fast.next;
            
            if (fast.next == null)
                break;
            
            fast = fast.next;
            slow = slow.next;
        }
        
        Node list2 = slow.next;
        
        slow.next = null;
        
        Node revlist2 = ReverseSLinkedList.reverse(list2);
        
        Node l0 = h;
        Node ln = revlist2;
        
        Node lhead = null;
        Node lcurr = null;
        
        Node t = l0;
        
        l0 = l0.next;
        t.next = null;
        
        lhead = t;
        lcurr = t;
        
        while (ln != null || l0 != null)
        {
            
            if (ln != null)
            {
                t = ln;
                ln = ln.next;
                t.next = null;
                lcurr.next = t;
                lcurr = lcurr.next;
            }
            
            if (l0 != null)
            {
                t = l0;
                l0 = l0.next;
                t.next = null;
                lcurr.next = t;
                lcurr = lcurr.next;
            }
            
        }
        
        return lhead;
    }
    
    public static void main(String[] args)
    {
        
        Node<Integer> h = new Node<Integer>(0, null);
        
        h.next = new Node<Integer>(1, null);
        h.next.next = new Node<Integer>(2, null);
        h.next.next.next = new Node<Integer>(3, null);
        h.next.next.next.next = new Node<Integer>(4, null);
        h.next.next.next.next.next = new Node<Integer>(5, null);
        h.next.next.next.next.next.next = new Node<Integer>(6, null);
        h.next.next.next.next.next.next.next = new Node<Integer>(7, null);
        h.next.next.next.next.next.next.next.next = new Node<Integer>(8, null);
        
        log(h.toFullString());
        
        h = zip(h);
        
        log(h.toFullString());
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
