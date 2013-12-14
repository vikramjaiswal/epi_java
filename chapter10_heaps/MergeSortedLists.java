import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLists {

    private static class MyComparator implements Comparator<PQObject> {

	@Override
	public int compare(PQObject o1, PQObject o2) {

	    if (o1.value > o2.value)
		return 1;
	    else if (o1.value < o2.value)
		return -1;

	    return 0;
	}
    }

    private class PQObject {

	int listId;
	int value;

	PQObject(int listId, int value) {

	    this.listId = listId;
	    this.value = value;
	}

	@Override
	public String toString() {
	    return "PQObject [listId=" + listId + ", value=" + value + "]";
	}
    }

    public MergeSortedLists() {

    }

    public List<Integer> mergeSorted(List<List<Integer>> lists) {

	List<Integer> sortedList = new ArrayList<Integer>();

	int size = lists.size();

	PriorityQueue<PQObject> minPQ = new PriorityQueue<PQObject>(size,
		new MyComparator());

	int[] listIndexes = new int[size];

	for (int listId = 0; listId < size; listId++) {

	    List<Integer> list = lists.get(listId);
	    if (list.size() > 0)
		minPQ.add(new PQObject(listId, list.get(listIndexes[listId]++)));
	}

	while (!minPQ.isEmpty()) {

	    PQObject minPQObject = minPQ.remove();
	    sortedList.add(minPQObject.value);

	    List<Integer> list = lists.get(minPQObject.listId);

	    if (list.size() > listIndexes[minPQObject.listId])
		minPQ.add(new PQObject(minPQObject.listId, list
			.get(listIndexes[minPQObject.listId]++)));

	}

	return sortedList;
    }

    public static void main(String[] args) {

	List<Integer> list0 = new ArrayList<Integer>();
	list0.add(0);
	list0.add(2);
	list0.add(8);
	list0.add(10);
	list0.add(12);
	list0.add(18);
	list0.add(20);
	list0.add(22);
	list0.add(28);

	List<Integer> list1 = new ArrayList<Integer>();
	list1.add(1);
	list1.add(3);
	list1.add(5);
	list1.add(7);
	list1.add(9);
	list1.add(11);
	list1.add(13);
	list1.add(15);
	list1.add(17);
	list1.add(19);
	list1.add(21);
	list1.add(23);
	list1.add(25);
	list1.add(27);
	list1.add(29);

	List<Integer> list2 = new ArrayList<Integer>();
	list2.add(20);
	list2.add(24);
	list2.add(31);
	list2.add(34);
	list2.add(36);
	list2.add(37);

	List<Integer> list3 = new ArrayList<Integer>();
	list3.add(32);
	list3.add(33);
	list3.add(35);
	list3.add(38);
	list3.add(39);

	List<Integer> list4 = new ArrayList<Integer>();

	List<List<Integer>> lists = new ArrayList<List<Integer>>();

	lists.add(list0);
	lists.add(list1);
	lists.add(list2);
	lists.add(list3);
	lists.add(list4);

	MergeSortedLists mergeSortedLists = new MergeSortedLists();

	List<Integer> sortedList = mergeSortedLists.mergeSorted(lists);

	log(sortedList);
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
