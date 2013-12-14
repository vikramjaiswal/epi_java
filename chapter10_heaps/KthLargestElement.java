import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElement {

    private static class ElementComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

	    return o1.compareTo(o2);
	}
    }

    public KthLargestElement() {
    }

    public static void printKthLargestElement(int k, InputStream in) {

	Scanner sc = new Scanner(in);

	PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(k,
		new ElementComparator());

	String line = null;
	Integer curr = null;

	int i = 0;

	for (; i < k && sc.hasNextLine(); i++) {

	    line = sc.nextLine();
	    curr = Integer.parseInt(line);

	    minPQ.add(curr);
	    log(minPQ.peek());
	}
	
	log("_________________");

	while (sc.hasNextLine()) {

	    line = sc.nextLine();
	    curr = Integer.parseInt(line);

	    if (minPQ.peek() < curr) {

		int removed = minPQ.remove();
		minPQ.add(curr);
	    }

	    log(minPQ.peek());

	}

    }

    public static void main(String[] args) throws FileNotFoundException {

	int k = 3;
	String fileName = "KthLargestTest1.txt";

	File file = new File(fileName);

	InputStream in = new FileInputStream(fileName);
	
	printKthLargestElement(k, in);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
