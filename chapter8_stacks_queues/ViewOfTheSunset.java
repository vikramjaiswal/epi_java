import java.util.ArrayList;
import java.util.List;

public class ViewOfTheSunset {
    public static class Building {
	String id;
	int height;

	Building(String id, int height) {
	    this.id = id;
	    this.height = height;
	}
    }

    public ViewOfTheSunset() {
    }

    public static MyStack<Building> getBuildingsWithSunSetView(
	    List<Building> bldgs) {
	MyStack<Building> st = new MyStack<Building>();

	for (Building b : bldgs) {
	    // remove from st all <= h
	    while (!st.isEmpty() && b.height >= st.peek().height) {
		if (b.height >= st.peek().height)
		    st.pop();
	    }

	    if (st.isEmpty() || st.peek().height > b.height) {
		st.push(b);
	    }
	}

	return st;
    }

    public static void main(String[] args) {
	ArrayList<Building> list = new ArrayList<Building>();

	list.add(new Building("A", 7));
	list.add(new Building("B", 7));
	list.add(new Building("C", 4));
	list.add(new Building("D", 6));
	list.add(new Building("E", 4));
	list.add(new Building("F", 4));
	list.add(new Building("G", 5));
	list.add(new Building("H", 1));

	MyStack<Building> st = getBuildingsWithSunSetView(list);

	while (!st.isEmpty()) {
	    Building b = st.pop();
	    log(b.id + ":" + b.height);
	}
    }

    private static void log(Object object) {
	System.out.println(object);
    }

}
