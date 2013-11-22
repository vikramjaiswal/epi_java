public class Node<Item>
{
    protected Item value;
    protected Node next;
    
    public Node(Item value, Node next)
    {
        this.value = value;
        this.next = next;
    }
    

    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(value);
        sb.append(",");
        
        if (next == null)
            sb.append("null");
        else
            sb.append("next set");
        
        return sb.toString();
    }
    
    public String toFullString() {
        
        
        StringBuilder sb = new StringBuilder();
        
        Node pointer = this;
        
        sb.append(pointer.value);
        
        while (pointer.next != null){
            
            sb.append(", ");
            sb.append(pointer.next.value);
            
            pointer = pointer.next;
        }
        
        return sb.toString();
    }
    
    
    
}
