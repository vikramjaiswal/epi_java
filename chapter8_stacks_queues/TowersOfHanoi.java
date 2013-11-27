public class TowersOfHanoi {

    public TowersOfHanoi() {
    }

    public static void move(int n, boolean moveRight) {

	if (n == 0)
	    return;

	move(n - 1, !moveRight);

	if (moveRight)
	    log("move " + n + " right");
	else
	    log("move " + n + " left");

	move(n - 1, !moveRight);

    }

    public static void moveUsingStack(int n) {

	MyStack<Integer> p1 = new MyStack<Integer>();
	MyStack<Integer> p2 = new MyStack<Integer>();
	MyStack<Integer> p3 = new MyStack<Integer>();

	for (int i = n; i > 0; i--) {
	    p1.push(i);
	}

	MyStack[] stacks = new MyStack[] { p1, p2, p3 };

	moveUsingStack(3, stacks, 0, 2, 1);

	int noop = 0;

    }

    private static void moveUsingStack(int n, MyStack[] stacks, int from,
	    int to, int use) {

	if (n == 0)
	    return;

	moveUsingStack(n - 1, stacks, from, use, to);

	stacks[to].push(stacks[from].pop());

	log("move " + n + " from:" + from + " to:" + to);

	moveUsingStack(n - 1, stacks, use, to, from);

    }

    public static void main(String[] args) {
	move(3, false);

	log("__________________________");

	moveUsingStack(3);

	log("__________________________");

    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
