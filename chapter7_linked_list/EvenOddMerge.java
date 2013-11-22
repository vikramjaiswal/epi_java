public class EvenOddMerge
{
    
    public EvenOddMerge()
    {
    }
    
    public static Node evenOddMerge(Node head){
        
        Node current = head;
        
        Node cEvenNode = null;
        Node cOddNode  = null;
        
        cEvenNode = current;
        
        current = current.next;
        
        if (current != null) {       
            cOddNode = current;
            current = current.next;
        }
        
        Node cEvenHead = cEvenNode;
        Node cOddHead  = cOddNode;
               
        while (current!= null) {
            
            cEvenNode.next = current;
            cEvenNode = cEvenNode.next;
            
            current = current.next;
            
            if (current == null) {
                cOddNode.next = null;
                break;
            }    
            
            cOddNode.next = current;
            cOddNode = cOddNode.next;
            
            current = current.next;
        }
        
        
        cEvenNode.next = cOddHead;
        
        return cEvenHead;
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
         
        log(h.toFullString());
        
        h = evenOddMerge(h);
        
        log(h.toFullString());
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
