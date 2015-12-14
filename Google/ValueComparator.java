package Google;

import java.util.Comparator;
import java.util.Map;

class ValueComparator implements Comparator<Object> {
	 
	Map<?, ?> map;
 
	public ValueComparator(Map<?, ?> map) {
		this.map = map;
	}
 
	public int compare(Object keyA, Object keyB) {
		Comparable<?> valueA = (Comparable<?>) map.get(keyA);
		Comparable<Comparable<?>> valueB = (Comparable<Comparable<?>>) map.get(keyB);
		return valueB.compareTo(valueA);
	}
}