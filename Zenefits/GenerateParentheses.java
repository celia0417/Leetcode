package Zenefits;

import java.util.*;

public class GenerateParentheses {
	private List<String> res = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		dfs(0, 0, n, new StringBuilder());
		return res;
	}

	public void dfs(int left, int right, int n, StringBuilder sb) {
		if (sb.length() == n * 2) {
			res.add(sb.toString());
			return;
		}

		if (left < n) {
			int len1 = sb.length();
			sb.append("(");
			dfs(left + 1, right, n, sb);
			sb.delete(len1, sb.length());
		}
		if (right < left) {
			int len2 = sb.length();
			sb.append(")");
			dfs(left, right + 1, n, sb);
			sb.delete(len2, sb.length());
		}
	}

	public List<String> generateParenthesis2(int n) {
		List<List<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList(""));

		for (int i = 1; i <= n; ++i) {
			List<String> list = new ArrayList<>();

			for (int j = 0; j < i; ++j) {
				for (String first : lists.get(j)) {
					for (String second : lists.get(i - 1 - j)) {
						list.add("(" + first + ")" + second);
					}
				}
			}
			lists.add(list);
		}
		return lists.get(lists.size() - 1);
	}

	public static void main(String args[]) {
		GenerateParentheses gp = new GenerateParentheses();
		System.out.println(gp.generateParenthesis(3));
		System.out.println(gp.generateParenthesis2(3));
	}
}
