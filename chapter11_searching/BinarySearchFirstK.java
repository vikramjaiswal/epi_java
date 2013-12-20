public class BinarySearchFirstK {

    public BinarySearchFirstK() {
    }

    public static int searchFirst(int[] a, int k) {

	int lo = 0;
	int hi = a.length - 1;

	int mid = -1;

	while (lo <= hi) {

	    mid = lo + (hi - lo) / 2;

	    if (a[mid] < k) {

		lo = mid + 1;

	    } else if (a[mid] > k) {

		hi = mid - 1;

	    } else { // a[mid] == k

		if (mid == 0 || a[mid - 1] != k)
		    return mid;
		else
		    hi = mid - 1;
	    }
	}

	return -1;
    }

    public static void main(String[] args) {

	int a[] = new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };

	log(searchFirst(a, 108));
	assert (searchFirst(a, 108) == 3);

	log(searchFirst(a, 285));
	assert (searchFirst(a, 285) == 6);

	log(searchFirst(a, 401));
	assert (searchFirst(a, 401) == 9);

	a = new int[] { -14, -14, -14, 108, 108, 243, 285, 401, 401, 401 };

	log(searchFirst(a, -14));
	assert (searchFirst(a, -14) == 0);

	log(searchFirst(a, 401));
	assert (searchFirst(a, 401) == 7);

	log(searchFirst(a, 109));
	assert (searchFirst(a, 109) == -1);

	log(searchFirst(a, -20));
	assert (searchFirst(a, -20) == -1);

	log(searchFirst(a, 405));
	assert (searchFirst(a, 405) == -1);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
