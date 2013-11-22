public class PalindromicityLinkedList
{
    
    public PalindromicityLinkedList()
    {
    }
    
    public static boolean testPalindromicity(Node head)
    {
        
        Node slow = head;
        Node fast = head.next;
        
        while (fast.next != null)
        {
            
            fast = fast.next;
            
            if (fast.next == null)
                break;
            
            fast = fast.next;
            slow = slow.next;
        }
        
        slow = slow.next;
        
        log(slow.toFullString());
        log(fast.toFullString());
        
        Node forward = head;
        Node reverse = ReverseSLinkedList.reverse(slow);;

        //log("forward:" +forward.toFullString());
        //log("reverse:" + reverse.toFullString());
        
        
        if (!forward.value.equals( reverse.value)) return false;

        
        while (reverse.next != null) {
         
         if (!reverse.value.equals( forward.value)) return false;
         
         reverse = reverse.next; forward = forward.next;
         
       }
                 
        return true;
    }
    
    /*
     * public static boolean testPalindromicity (Node head){
     * 
     * Node pointer = head;
     * 
     * int count = 1;
     * 
     * while (pointer.next !=null) {
     * 
     * pointer = pointer.next; count ++; }
     * 
     * 
     * int mid =(count+1)/2;
     * 
     * pointer = head; for (int i=0; i<mid; i++){
     * 
     * pointer = pointer.next; }
     * 
     * 
     * Node pointerRev = ReverseSLinkedList.reverse(pointer);
     * log(pointerRev.toFullString());
     * 
     * pointer = head;
     * 
     * if (!pointerRev.value.equals( pointer.value)) return false;
     * 
     * 
     * while (pointerRev.next != null) {
     * 
     * if (!pointerRev.value.equals( pointer.value)) return false;
     * 
     * pointerRev = pointerRev.next; pointer = pointer.next; }
     * 
     * 
     * return true; }
     */
    
    public static void main(String[] args)
    {
         Node<Integer> h = new Node<Integer>(1, null); h.next = new
         Node<Integer>(2, null); h.next.next = new Node<Integer>(3, null);
         h.next.next.next = new Node<Integer>(4, null); h.next.next.next.next = new Node<Integer>(5, null);
         h.next.next.next.next.next = new Node<Integer>(4, null);
         h.next.next.next.next.next.next = new Node<Integer>(3, null); 
         h.next.next.next.next.next.next.next = new Node<Integer>(2, null);
         h.next.next.next.next.next.next.next.next = new Node<Integer>(1, null);

        
        /*
        Node<Integer> h = new Node<Integer>(1, null);
        h.next = new Node<Integer>(2, null);
        h.next.next = new Node<Integer>(3, null); h.next.next.next = new
        Node<Integer>(4, null); h.next.next.next.next = new Node<Integer>(4, null);
        h.next.next.next.next.next = new Node<Integer>(3, null);
        h.next.next.next.next.next.next = new Node<Integer>(2, null);
        h.next.next.next.next.next.next.next = new Node<Integer>(1, null);
        */
        
        log(h.toFullString());
        
        log(testPalindromicity(h));
    }
    
    private static void log(Object object)
    {
        System.out.println(object);
    }
    
}
