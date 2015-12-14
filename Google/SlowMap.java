package Google;

import java.util.*;
import java.util.Map.Entry;

public class SlowMap extends AbstractMap {

	private List keys = new ArrayList(), values = new ArrayList();

	public Object put(Object key, Object value) {
		Object result = get(key);
		if (!keys.contains(key)) {
			keys.add(key);
			values.add(value);
		} else
			values.set(keys.indexOf(key), value);
		return result;
	}

	public Object get(Object key) {
		if (!keys.contains(key))
			return null;
		return values.get(keys.indexOf(key));
	}

	public Set entrySet() {
		Set entries = new HashSet();
		Iterator ki = keys.iterator(), vi = values.iterator();
		while (ki.hasNext())
			entries.add(new MPair(ki.next(), vi.next()));
		return entries;
	}

	public String toString() {
		StringBuffer s = new StringBuffer("{");
		Iterator ki = keys.iterator(), vi = values.iterator();
		while (ki.hasNext()) {
			s.append(ki.next() + "=" + vi.next());
			if (ki.hasNext())
				s.append(", ");
		}
		s.append("}");
		return s.toString();
	}

	public static void main(String[] args) {
		SlowMap m = new SlowMap();
		m.put("Adobe", "Mountain View, CA");
		m.put("IBM", "White Plains, NY");
		m.put("Learning Tree", "Los Angeles, CA");
		m.put("Microsoft", "Redmond, WA");
		m.put("Netscape", "Mountain View, CA");
		m.put("O'Reilly", "Sebastopol, CA");
		m.put("Sun", "Mountain View, CA");
		System.out.println(m);

	}
} /// :~

class MPair implements Entry, Comparable {
	Object key, value;

	MPair(Object k, Object v) {
		key = k;
		value = v;
	}

	public Object getKey() {
		return key;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object v) {
		Object result = value;
		value = v;
		return result;
	}

	public boolean equals(Object o) {
		return key.equals(((MPair) o).key);
	}

	public int compareTo(Object rv) {
		return ((Comparable) key).compareTo(((MPair) rv).key);
	}
} /// :~