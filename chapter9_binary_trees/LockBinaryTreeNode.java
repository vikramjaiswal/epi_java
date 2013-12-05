public class LockBinaryTreeNode {
    private boolean locked = false;
    private int countChildrenLocks = 0;

    public int value;
    public LockBinaryTreeNode parent;
    public LockBinaryTreeNode left;
    public LockBinaryTreeNode right;

    public LockBinaryTreeNode() {
    }

    public boolean isLock() {

	return locked;
    }

    public boolean lock() {
	if (locked)
	    return false;

	if (countChildrenLocks == 0 && !locked) {
	    // make sure all parents are not locked
	    LockBinaryTreeNode mparent = this.parent;

	    while (mparent != null) {
		if (mparent.locked)
		    return false;

		mparent = mparent.parent;
	    }

	    // lock itseld and update its parents
	    locked = true;

	    mparent = this.parent;

	    while (mparent != null) {
		mparent.countChildrenLocks++;
		mparent = mparent.parent;
	    }

	    return true;
	}

	return false;
    }

    public void unLock() {

	if (locked) {

	    locked = false;

	    LockBinaryTreeNode mparent = this.parent;

	    while (mparent != null) {
		mparent.countChildrenLocks--;
		mparent = mparent.parent;
	    }
	}
    }

    public static void main(String[] args) {

    }

}
