public class BSTNode<Key extends Comparable<Key>, Value> {
    
    protected Key key; 
    protected Value value;
    
    protected BSTNode<Key, Value> left;
    protected BSTNode<Key, Value> right;
    protected int size;

    public BSTNode(Key key, Value value, int size) {

	this.key = key;
	this.value = value;
	this.size = size;
    }
    
    public String toString() {
	StringBuilder sb = new StringBuilder();
	
	sb.append("key=" + key);
	sb.append(",value=" + value + " ");
	
	if (left != null)
	    sb.append("left=SET");
	else
	    sb.append("left=null");

	if (right != null)
	    sb.append("right=SET");
	else
	    sb.append("right=null");

	return sb.toString();
    }
    

    public static void main(String[] args) {

    }
    
    
    public static void printBSTLevelOrder(BSTNode root) {
	Queue<BSTNode> q = new Queue<BSTNode>();

	q.enqueue(root);
	int countBlock = 0;
	int countProcessed = 0;

	int count = 0;

	while (!q.isEmpty()) {
	    countBlock = q.size();
	    countProcessed = 0;

	    while (countProcessed < countBlock) {
		BSTNode n = q.dequeue();

		log1(n.key + "," + n.value + " ");
		countProcessed++;

		if (n.left != null)
		    q.enqueue(n.left);

		if (n.right != null)
		    q.enqueue(n.right);
	    }

	    log1("\n");
	}

    }

    private static void log1(Object object) {
	System.out.print(object);
    }
    

}
