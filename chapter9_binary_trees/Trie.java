public class Trie {

    //private final static int R = 26;
    private final static int R = 255;

    private TrieNode root = null;

    private class TrieNode {

	Object value;
	TrieNode[] nodes = new TrieNode[R];
    }

    public Trie() {

	root = new TrieNode();
    }

    public boolean put(String key, Object value) {

	//key = key.toLowerCase();

	TrieNode curr = root;
	int cKey = -1;
	int d = 0;

	for (; d < key.length(); d++) {

	    cKey = getKeyInt(key.charAt(d));

	    if (curr.nodes[cKey] == null) 
		curr.nodes[cKey] = new TrieNode();

	    curr = curr.nodes[cKey];
	}

	if (curr.value == null || !curr.value.equals(value)) {

	    curr.value = value;
	    return true;
	}

	return false;
    }

    private static int getKeyInt(char c) {

	//int key = Character.getNumericValue(c) - Character.getNumericValue('a');
	int key = Character.getNumericValue(c);
	return key;
    }

    public Object get(String key) {

	key = key.toLowerCase();

	TrieNode curr = root;
	int cKey = -1;
	int d = 0;

	for (; d < key.length(); d++) {

	    cKey = getKeyInt(key.charAt(d));

	    if (curr.nodes[cKey] == null) 
		return null;

	    curr = curr.nodes[cKey];
	}

	return curr.value;
    }
    
    
    public String getShortestUniquePrefix(String key) {

	key = key.toLowerCase();

	TrieNode curr = root;
	int cKey = -1;
	int d = 0;

	for (; d < key.length(); d++) {

	    cKey = getKeyInt(key.charAt(d));

	    if (curr.nodes[cKey] == null) 
		return key.substring(0, d+1);

	    curr = curr.nodes[cKey];
	}

	return "E";
    }
    
    
    
    public boolean contains (String key) {
	
	return get(key) != null;
    }
    

    public static void main(String[] args) {

	String suprefix = null;
	/*
	log(trie.contains("cat") );
	log(trie.put("cat", "CAT"));
	log(trie.put("cat", "CAT1"));
	log(trie.contains("cat") );
	log(trie.get("cat") );
	*/
	
	Trie trie = new Trie();		
	trie.put("dog", "dog");
	trie.put("be", "be");
	trie.put("cut", "cut");
	suprefix = trie.getShortestUniquePrefix("cat");
	assert(suprefix.equals("ca"));
	
	trie.put("car", "car");
	suprefix = trie.getShortestUniquePrefix("cat");
	assert(suprefix.equals("cat"));

	trie.put("cat", "cat");
	suprefix = trie.getShortestUniquePrefix("cat");
	assert(suprefix.equals("E"));

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
