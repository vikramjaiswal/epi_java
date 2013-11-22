public class MergeSortedLinkedLists
{
    
    public MergeSortedLinkedLists()
    {
    }
    
    private static int compare(int li, int lf)
    {
        
        if (li == lf)
            return 0;
        
        if (li < lf)
            return -1;
        
        return 1;
        
    }
    
    public static Node merge(Node<Integer> l, Node<Integer> f)
    {
        
        Node<Integer> head = null;
        Node<Integer> tail = null;
        
        while (l != null && f != null)
        {
            if (compare(l.value, f.value) != 1)
            {                
                if (head == null)
                {
                    head = l;
                    tail = l;
                } else
                {
                    tail.next = l;
                    tail = tail.next;
                }
                
                l = l.next;
                
            } else
            {
                
                if (head == null)
                {
                    head = f;
                    tail = f;
                } else
                {
                    tail.next = f;
                    tail = tail.next;
                }
                
                f = f.next;
            }
        }
        
        if (l == null)
            tail.next = f;
        
        if (f == null)
            tail.next = l;
        
        return head;
    }
    
    public static void main(String[] args)
    {
        Node<Integer> l = new Node<Integer>(2, new Node<Integer>(5, new Node<Integer>(7, null)));
        log ("l=" + l);
        
        Node<Integer> f = new Node<Integer>(3, new Node<Integer>(11, new Node<Integer>(15, null)));
        log ("f=" + f);
        
        Node m = merge(l, f);
        log ("m=" + m);  
        
 
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }

    
}
