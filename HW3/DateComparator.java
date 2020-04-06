import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;

public class DateComparator implements Comparator<SimpleEntry<String, Date>> {
	public int compare(SimpleEntry<String, Date> o1, SimpleEntry<String, Date> o2) {
		return (o1.getValue()).compareTo((o2.getValue()));
	}
}