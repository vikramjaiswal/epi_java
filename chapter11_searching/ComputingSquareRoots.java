public class ComputingSquareRoots {

    public ComputingSquareRoots() {
    }

    public static double squareroot(double a) {

	double lo = 0;
	double hi = a;

	if (a >= 1.0) {

	    lo = 1.0;
	    hi = a;

	} else {

	    lo = a;
	    hi = 1.0;
	}

	while (lo <= hi) {

	    double mid = lo + (hi - lo) * 0.5;

	    double midSq = mid * mid;

	    if (equal(midSq, a))
		return (double) Math.round(mid * 1000) / 1000;
	    else if (midSq < a)
		lo = mid;
	    else		// midSq > a
		hi = mid;
	}

	return -1;
    }

    private static boolean equal(double a, double midSq) {

	double diff = Math.abs(a - midSq);

	if (diff < 0.0001)
	    return true;

	return false;
    }

    public static void main(String[] args) {

	log(squareroot(2));
	assert (squareroot(2) == 1.414);

	log(squareroot(5));
	assert (squareroot(5) == 2.236);

	log(squareroot(.9));
	assert (squareroot(.9) == 0.949);

	log(squareroot(.81));
	assert (squareroot(.81) == 0.9);

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
