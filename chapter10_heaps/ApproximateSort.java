import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ApproximateSort {

    public ApproximateSort() {
    }

    private static class NumberComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {

	    return o1.compareTo(o2);
	}
    }

    public static void printSorted(int k, InputStream in) {

	Scanner sc = new Scanner(in);

	PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(k + 1,
		new NumberComparator());

	String line = null;
	Integer curr = null;

	int i = 0;

	for (; i < k && sc.hasNextLine(); i++) {

	    line = sc.nextLine();
	    curr = Integer.parseInt(line);

	    minPQ.add(curr);
	}

	while (sc.hasNextLine()) {

	    line = sc.nextLine();
	    curr = Integer.parseInt(line);

	    minPQ.add(curr);

	    assert (minPQ.size() == (k + 1));

	    int orderedInt = minPQ.remove();
	    log(orderedInt);
	}

	while (!minPQ.isEmpty()) {

	    int orderedInt = minPQ.remove();
	    log(orderedInt);
	}
    }

    public static void main(String[] args) throws FileNotFoundException {

	int k = 3;
	String fileName = "ApproximateSort.txt";

	File file = new File(fileName);

	InputStream in = new FileInputStream(fileName);

	printSorted(k, in);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
