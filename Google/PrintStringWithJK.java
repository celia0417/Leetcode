package Google;

import java.util.*;

public class PrintStringWithJK {
	public List<String> print(String str) {
		char[] special = new char[] { 'j', 'k' };
		List<String> res = new ArrayList<String>();
		dfs(new StringBuilder(), str, res, 0, special);
		return res;
	}

	public void dfs(StringBuilder sb, String str, List<String> res, int start, char[] special) {
		if (str.length() == sb.length()) {
			res.add(sb.toString());
		}
		for (int i = start; i < str.length(); i++) {
			int len = sb.length();
			if (str.charAt(i) == '*') {
				for (char c : special) {
					sb.append(c);
					dfs(sb, str, res, i + 1, special);
					sb.delete(len, sb.length());
				}
			} else {
				sb.append(str.charAt(i));
				dfs(sb, str, res, i + 1, special);
				sb.delete(len, sb.length());
			}
		}
	}

	// 1, 0 , ?
	public List<String> print2(String str) {
		char[] special = new char[] { '?', '1', '0' };
		List<String> res = new ArrayList<String>();
		Set<Integer> visited = new HashSet<>();
		helper(new StringBuilder(), str, res, special, visited);
		return res;
	}

	public void helper(StringBuilder sb, String str, List<String> res, char[] special, Set<Integer> visited) {
		if (str.length() == sb.length()) {
			if (!res.contains(sb.toString()))
				res.add(sb.toString());
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			if (visited.contains(i)) continue;
			int len = sb.length();
			if (str.charAt(i) == '?') {
				for (char c : special) {
					sb.append(c);
					visited.add(i);
					helper(sb, str, res, special, visited);
					sb.delete(len, sb.length());
					visited.remove(i);
				}
			} else {
//				int len = sb.length();
				sb.append(str.charAt(i));
				visited.add(i);
				helper(sb, str, res, special, visited);
				sb.delete(len, sb.length());
				visited.remove(i);
			}
		}
	}

	public static void main(String args[]) {
		PrintStringWithJK sjk = new PrintStringWithJK();
		List<String> res = sjk.print("s*gg*dg");
		for (String r : res) {
			System.out.println(r);
		}
		List<String> res2 = sjk.print2("10?");
		for (String r : res2) {
			System.out.println(r);
		}
	}
}
