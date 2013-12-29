import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Anagrams {

    public Anagrams() {
    }

    private class Key {

	char[] ca;
	int hash;

	Key(char[] ca) {

	    this.ca = ca;
	}

	public int hashCode() {

	    int h = hash;
	    int len = ca.length;

	    if (h == 0 && len > 0) {

		for (int i = 0; i < len; i++) {
		    h = 31 * h + ca[i];
		}
		hash = h;
	    }
	    return h;
	}

	public boolean equals(Object anObject) {
	    if (this == anObject) {
		return true;
	    }
	    if (anObject instanceof Key) {

		Key anotherKey = (Key) anObject;

		int n = ca.length;
		if (n == anotherKey.ca.length) {

		    char v1[] = ca;
		    char v2[] = anotherKey.ca;
		    int i = 0;
		    int j = 0;
		    while (n-- != 0) {
			if (v1[i++] != v2[j++])
			    return false;
		    }
		    return true;
		}
	    }
	    return false;
	}

    }

    public Collection<Set<String>> getAnagramsSets(String[] dictionary) {

	HashMap<Key, Set<String>> map = new HashMap<Key, Set<String>>();

	for (int i = 0; i < dictionary.length; i++) {

	    char[] ca = dictionary[i].toLowerCase().toCharArray();
	    Arrays.sort(ca, 0, ca.length);

	    Key key = new Key(ca);

	    if (map.containsKey(key)) {
		map.get(key).add(dictionary[i]);

	    } else {
		Set<String> hs = new HashSet<String>();
		hs.add(dictionary[i]);
		map.put(key, hs);
	    }

	}

	return map.values();
    }

    public static void main(String[] args) {


	String[] dictionary = new String[] { "Resistance", "Gainly", "Admirer",
		"Sadder", "Protectional", "Orchestra", "Creative",
		"Deductions", "Listen", "Replays", "Crudities", "Paternal",
		"Angered", "Discriminator", "Serbia", "Ancestries", "Laying",
		"Married", "Dreads", "Lactoprotein", "Carthorse", "Reactive",
		"Discounted", "Silent", "Parsley", "Diuretics", "Parental",
		"Enraged", "Doctrinairism", "Rabies", "Debit card",
		"Bad credit", "Eleven plus two", "Twelve plus one", "One" };
	
	
	//String[] dictionary = new String[] { "ab", "ba" };
	
	

	Anagrams anagrams = new Anagrams();

	Collection<Set<String>> coll = anagrams.getAnagramsSets(dictionary);
	
	log("_____________________");

	for (Set<String> set : coll) {
	    
	    log(set);

	    /*
	    log("_____________________");

	    for (String str : set) {
		log(str);
	    }*/

	}
	
	log("_____________________");

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
