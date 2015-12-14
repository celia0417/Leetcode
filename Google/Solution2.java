package Google;

import java.util.*;

public class Solution2 {

	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		Set<String> set = new HashSet<String>();
		set.add("leet");
		set.add("co");
		set.add("c");
		set.add("de");
		String res = solution.wordSplit("leetcode", set);
		System.out.println(res.length());
		System.out.println(res);
	}

	public String wordSplit(String s, Set<String> Dict) {
		int[] position = new int[s.length() + 1];
		Arrays.fill(position, -1);
		position[0] = 0;
		for (int j = 1; j <= s.length(); j++) {
			for (int i = 0; i < j; i++) {
				if (position[i] != -1 && Dict.contains(s.substring(i, j))) {
					position[j] = i;
				}
			}
		}
		if (position[s.length()] == -1)
			return "";
		int i = s.length();
		StringBuilder sb = new StringBuilder();
		while (i != 0) {
			sb.insert(0, " " + s.substring(position[i], i));
			i = position[i];
		}
		return sb.toString();

	}
}
