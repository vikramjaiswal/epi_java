public class BinarySearchLargerK {

    public BinarySearchLargerK() {
    }

    public static int searchLarger(int[] a, int k) {

	int lo = 0;
	int hi = a.length - 1;

	int mid = -1;
	int last = -1;

	while (lo <= hi) {

	    mid = lo + (hi - lo) / 2;

	    if (a[mid] > k) {

		last = mid;
		hi = mid - 1;

	    } else if (a[mid] < k) {

		lo = mid + 1;

	    } else { // a[mid] == k

		lo = mid + 1;
	    }
	}

	return last;
    }

    public static void main(String[] args) {

	int a[] = new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };

	log(searchLarger(a, 500));
	assert (searchLarger(a, 500) == -1);

	log(searchLarger(a, 101));
	assert (searchLarger(a, 101) == 3);

	log(searchLarger(a, 401));
	assert (searchLarger(a, 401) == -1);

	log(searchLarger(a, -14));
	assert (searchLarger(a, -14) == 1);

	log(searchLarger(a, 109));
	assert (searchLarger(a, 109) == 5);
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
