public class MedianSortedCircularLinkedList
{
    public MedianSortedCircularLinkedList()
    {
    }
    
    
    public static int getMedian(Node<Integer> node) {
        
        Node<Integer> currentNode   = node ;
        Node<Integer> nextNode  = currentNode.next;
        
        while ( nextNode.value > currentNode.value ) {
            currentNode = currentNode.next;
            nextNode = nextNode.next;
        }
        
        Node<Integer> minNode = nextNode ;
        Node<Integer> maxNode = currentNode;
        
        
        Node<Integer> slow = minNode;
        Node<Integer> fast = minNode;
        
        
        while (slow.value <= fast.value && fast.value != maxNode.value ){
            
            fast = fast.next;
            fast = fast.next;
            
            slow = slow.next;
        }
        
        return slow.value;
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
        
        //h.next.next.next.next.next.next.next = new Node<Integer>(8, null);
        
        log (h);
        
        h.next.next.next.next.next.next.next = h;
        //h.next.next.next.next.next.next.next.next = h;
        
        log (getMedian(h.next.next));
        
    }
    
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
    
}
