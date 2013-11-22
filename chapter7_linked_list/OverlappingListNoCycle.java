public class OverlappingListNoCycle
{
    
    public OverlappingListNoCycle()
    {
    }
    

    
    public static Node findOverlapNode(Node h1, Node h2)
    {
        if (getTailNode(h1) != getTailNode(h2))
            return null;
        
        int c1 = getListLength(h1);
        int c2 = getListLength(h2);
        
        int longLcount = 0;
        int shortLcount = 0;
        
        Node longL;
        Node shortL;
        
        if (c1 > c2)
        {
            longL = h1;
            shortL = h2;
            longLcount = c1;
            shortLcount = c2;
            
        } else
        {
            longL = h2;
            shortL = h1;
            longLcount = c2;
            shortLcount = c1;
        }
        
        int diff = longLcount - shortLcount;
        
        while (diff > 0)
        {
            longL = longL.next;
            diff--;
        }
        
        while (longL != null && shortL != null)
        {
            if (longL == shortL)
                return longL;
            
            longL = longL.next;
            shortL = shortL.next;
        }
        
        return null;
    }
    
    private static int getListLength(Node h)
    {
        int c = 0;
        Node curr = h;
        
        while (curr != null)
        {
            c++;
            curr = curr.next;
        }
        
        return c;
    }
    
    private static Node getTailNode(Node h)
    {
        Node curr = h;
        
        while (curr.next != null)
            curr = curr.next;
        
        return curr;
    }
    
    public static void main(String[] args)
    {
        Node<Integer> h1 = new Node<Integer>(1, null);
        h1.next = new Node<Integer>(2, null);
        h1.next.next = new Node<Integer>(3, null);
        h1.next.next.next = new Node<Integer>(4, null);
        h1.next.next.next.next = new Node<Integer>(5, null);
        h1.next.next.next.next.next = new Node<Integer>(6, null);
        h1.next.next.next.next.next.next = new Node<Integer>(7, null);
        h1.next.next.next.next.next.next.next = new Node<Integer>(8, null);
        
        log(h1.toFullString());
        
        Node<Integer> h2 = new Node<Integer>(10, null);
        h2.next = new Node<Integer>(20, null);
        h2.next.next = new Node<Integer>(30, null);
        h2.next.next.next = new Node<Integer>(40, null);
        h2.next.next.next.next = new Node<Integer>(50, null);
        h2.next.next.next.next.next = h1.next.next;
        
        log(h2.toFullString());
        
        log(findOverlapNode(h2, h1)  );
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
