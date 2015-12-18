package Backtracking;

import java.util.*;

public class PalindromePermutation {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else
				map.put(s.charAt(i), 1);
		}
		int cnt = 0;
		String mid = "";
		List<Character> str = new ArrayList<>();
		for (Character key : map.keySet()) {
			if (map.get(key) % 2 == 1) {
				mid += key;
				cnt++;
			}
			if (cnt > 1)
				return res;
			for (int i = 0; i < map.get(key) / 2; i++) {
				str.add(key);
			}
		}
		Set<Integer> visited = new HashSet<>();
		dfs(str, res, mid, new StringBuilder(), str.size(), visited);
		return res;
	}

	public void dfs(List<Character> str, List<String> res, String mid, StringBuilder sb, int n, Set<Integer> visited) {
		if (sb.length() == n) {
			res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();

			return;
		}
		for (int i = 0; i < str.size(); i++) {
			if (i > 0 && str.get(i) == str.get(i - 1) && !visited.contains(i - 1))
				continue;
			if (!visited.contains(i)) {
				int len = sb.length();
				visited.add(i);
				sb.append(str.get(i));
				dfs(str, res, mid, sb, n, visited);
				sb.delete(len, sb.length());
				visited.remove(i);
			}
		}
	}

	public static void main(String args[]) {
		PalindromePermutation pp = new PalindromePermutation();
		List<String> res = pp.generatePalindromes("aaaabbcc");
		for (String s : res) {
			System.out.println(s);
		}
	}
}
