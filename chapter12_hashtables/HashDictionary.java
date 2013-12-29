public class HashDictionary {

    public HashDictionary() {
    }

    
    public static int hash (String word, int modulus){
	
	int r = 997;
	int hash = 0;
	
	for (int i =0; i < word.length(); i++ ) {
	    
	    hash = (hash * r + word.charAt(0)) % modulus;
	}
	
	
	return hash;
    }
    
    
    public static void main(String[] args) {
	
	int m = 1001;
	
	log (hash("bob", m));
	log (hash("hello", m));
    }
    
    
    private static void log(Object object) {
	System.out.println(object);
    }
    

}
