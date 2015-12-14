package Snapchat;

import java.util.*;

public class Match {
	public String match(String str, Set<String> dict) {
		if (str == null || dict == null || "".equals(str) || dict.isEmpty())
			return "";
		Queue<String> queue = new LinkedList<String>();
		queue.offer(str);
		while (!queue.isEmpty()) {
			Set<String> set = new HashSet<String>();
			String cur = queue.poll();
			if (dict.contains(cur)) {
				return cur;
			}
			for (int i = 0; i < cur.length(); i++) {
				String temp = cur.substring(0, i) + cur.substring(i + 1);
				if (!set.contains(temp))
					set.add(temp);
			}

			for (String key : set) {
				queue.offer(key);
			}
		}
		return "";
	}

	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>();
		Match solution = new Match();
		set1.add("h");
		set1.add("helo");
		System.out.println(solution.match("heelllo", set1));
		Set<String> set2 = new HashSet<String>();
		set2.add("hello");
		set2.add("pkj");
		System.out.println(solution.match("heelllo", set2));
		Set<String> set3 = new HashSet<String>();
		set3.add("eeee");
		set3.add("eee");
		System.out.println(solution.match("heeeel", set3));
		Set<String> set4 = new HashSet<String>();
		set4.add("");
		set4.add("lk");
		System.out.println(solution.match("", set4));
	}
}
