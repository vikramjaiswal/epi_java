import java.util.ArrayList;

public class IntersectTwoArrays3 {

    public IntersectTwoArrays3() {
    }

    public static int[] intersect(int[] a, int[] b) {

	ArrayList<Integer> cList = new ArrayList<Integer>();

	int i = 0;
	int j = 0;

	while (true) {

	    if (i == a.length || j == b.length)
		break;

	    if (a[i] == b[j] && (i == 0 || a[i] != a[i - 1])) {

		cList.add(a[i]);
		i++;
		j++;

	    } else if (a[i] < b[j]) {
		
		i++;
	    } else {
		
		j++;
	    }
	}

	int[] c = new int[cList.size()];

	for (int x = 0; x < c.length; x++) {
	    c[x] = cList.get(x);
	}

	return c;
    }

    public static void main(String[] args) {

	int[] a = new int[] { 2, 3, 4, 5, 10, 11, 12, 12 };
	int[] b = new int[] { 1, 1, 1, 2, 2, 3, 6, 7, 8, 9, 10 };

	int[] c = intersect(a, b);

	for (int x : c) {
	    log(x);
	}
	
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
