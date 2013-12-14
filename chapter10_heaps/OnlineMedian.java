import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class OnlineMedian {

    public OnlineMedian() {

    }

    public static void printRunningMedian(InputStream in) {

	Scanner sc = new Scanner(in);

	PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(11,
		Collections.reverseOrder());
	PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(11);

	Integer curr = null;

	if (sc.hasNextLine()) {
	    curr = Integer.parseInt(sc.nextLine());
	    maxPQ.add(curr);
	    log(maxPQ.peek());
	}

	while (sc.hasNextLine()) {

	    curr = Integer.parseInt(sc.nextLine());

	    if (curr <= maxPQ.peek())
		maxPQ.add(curr);
	    else
		minPQ.add(curr);

	    if (maxPQ.size() - minPQ.size() == 2)
		minPQ.add(maxPQ.remove());
	    else if (minPQ.size() - maxPQ.size() == 2)
		maxPQ.add(minPQ.remove());

	    assert (Math.abs(maxPQ.size() - minPQ.size()) <= 1);

	    if (maxPQ.size() > minPQ.size())
		log(maxPQ.peek());
	    else if (maxPQ.size() < minPQ.size())
		log(minPQ.peek());
	    else // maxPQ.size() = minPQ.size()
		log((maxPQ.peek() + minPQ.peek()) * 0.5 );
	}

    }

    public static void main(String[] args) throws FileNotFoundException {

	String fileName = "OnlineMedian.txt";

	File file = new File(fileName);

	InputStream in = new FileInputStream(fileName);

	printRunningMedian(in);
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
