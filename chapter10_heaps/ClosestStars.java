import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ClosestStars {

    private static class StarComparator implements Comparator<Star> {

	@Override
	public int compare(Star o1, Star o2) {

	    if (o1.distEarth < o2.distEarth)
		return 1;
	    else if (o1.distEarth > o2.distEarth)
		return -1;

	    return 0;
	}
    }

    private static class Star {

	String id;
	int x;
	int y;
	int z;

	double distEarth;

	Star(String id, int x, int y, int z) {

	    this.id = id;
	    this.x = x;
	    this.y = y;
	    this.z = z;
	    this.distEarth = Math.sqrt(x * x + y * y + z * z);
	}

	@Override
	public String toString() {
	    return "Star [id=" + id + ", x=" + x + ", y=" + y + ", z=" + z
		    + ", distEarth=" + distEarth + "]";
	}

    }

    public ClosestStars() {
    }

    public static List<Star> getKClosestStars(int k, InputStream in) {

	Scanner sc = new Scanner(in);

	PriorityQueue<Star> maxPQ = new PriorityQueue<Star>(k + 1,
		new StarComparator());

	String line = null;
	Star cStar = null;

	while (sc.hasNextLine()) {

	    line = sc.nextLine();

	    String[] s = line.split("\\s+");

	    cStar = new Star(s[0], Integer.parseInt(s[1]),
		    Integer.parseInt(s[2]), Integer.parseInt(s[2]));

	    if (maxPQ.size() < k || cStar.distEarth < maxPQ.peek().distEarth) {

		maxPQ.add(cStar);

		if (maxPQ.size() > k) {
		    maxPQ.remove();
		}
	    }

	    assert (maxPQ.size() <= k);
	}

	List<Star> kClosestStars = new ArrayList<Star>();

	while (!maxPQ.isEmpty())
	    kClosestStars.add(maxPQ.remove());

	return kClosestStars;
    }

    public static void main(String[] args) throws FileNotFoundException {

	int k = 3;
	String fileName = "ClosestStarsTest.txt";

	File file = new File(fileName);

	InputStream in = new FileInputStream(fileName);

	List<Star> closestStars = getKClosestStars(k, in);

	log(closestStars);
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
