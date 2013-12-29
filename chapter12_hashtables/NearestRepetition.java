import java.util.HashMap;

public class NearestRepetition {

    public NearestRepetition() {
    }

    public static String findNearestRepetition(String[] a) {

	HashMap<String, Integer> hm = new HashMap<String, Integer>();

	int nearestDist = Integer.MAX_VALUE;
	String nearestStr = null;

	for (int i = 0; i < a.length; i++) {

	    if (hm.containsKey(a[i])) {

		int t = hm.get(a[i]);

		if (i - t < nearestDist) {
		    nearestDist = (i - t);
		    nearestStr = a[i];
		}
	    }

	    hm.put(a[i], i);
	}

	log(nearestStr + " " + nearestDist);

	return nearestStr;
    }

    public static void main(String[] args) {

	String[] a = new String[] { "All", "work", "and", "no", "play",
		"makes", "for", "no", "work", "no", "fun", "and", "no",
		"results" };

	log(findNearestRepetition(a));

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
