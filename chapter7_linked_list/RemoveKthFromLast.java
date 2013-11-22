public class RemoveKthFromLast
{
    
    public RemoveKthFromLast()
    {
    }
    
    public static Node removeKthFromLast(Node head, int k)
    {        
        Node leader = head;
        
        for (int i = 0; i < k; i++)
            leader = leader.next;
                
        Node prev = null;
        Node curpointer = head;         
        
        while (leader.next != null)
        {
            prev = curpointer;
            leader = leader.next;
            curpointer = curpointer.next;
        }
        
        if (prev != null){
            prev.next = prev.next.next;
        } else {
            head = head.next;
        }
        
        
        return head;
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
        
        h.next.next.next.next.next.next.next = new Node<Integer>(8, null);
        
        Node deleteNode = h.next.next.next.next;
        
        log(h.toFullString());
        
        h = removeKthFromLast(h, 7);
        
        log(h.toFullString());
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
