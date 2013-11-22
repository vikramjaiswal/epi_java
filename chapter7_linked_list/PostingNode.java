public class PostingNode<Item>
{
    protected Item value;
    protected PostingNode next;
    protected PostingNode jump;
    
    public PostingNode(Item value, PostingNode next)
    {
        this.value = value;
        this.next = next;
    }
    
   /*
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(value);
        sb.append(",");
        
        if (next == null)
            sb.append("next=null");
        else
            sb.append("next set");
        
        if (jump == null)
            sb.append("jump=null");
        else
            sb.append("next set");
        
        
        
        return sb.toString();
    }*/
    
  
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        PostingNode pointer = this;
        
        sb.append(pointer.value);
        
        if (pointer.jump != null)
            sb.append("[" + pointer.jump.value + "]" );
        else
            sb.append("[null]" );
        
        while (pointer.next != null){
            
            sb.append(", ");
            sb.append(pointer.next.value);
            if (pointer.next.jump != null)
                sb.append("[" + pointer.next.jump.value + "]" );
            else
                sb.append("[null]" );
            
            pointer = pointer.next;
        }
        
        return sb.toString();
    }
    
    
    
}
