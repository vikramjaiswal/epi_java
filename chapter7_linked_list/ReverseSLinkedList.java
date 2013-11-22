public class ReverseSLinkedList
{
    
    public ReverseSLinkedList()
    {
    }
    

    public static Node reverse (Node head){
        
        Node prev = null;
        Node current = head;
        Node forward ;
        
        while (current != null){
            
            forward = current.next;            
            current.next = prev;;            
            prev = current;            
            current = forward;                        
        }
        
        
        return prev;              
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
        
        h = reverse(h);
        
        log(h.toFullString());
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }

}
