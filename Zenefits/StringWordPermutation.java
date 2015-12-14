package Zenefits;

import java.util.*;

public class StringWordPermutation {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "aab";
		ArrayList<String> res = getPermutations(s2, 2);
		System.out.println(res.size());
		for (String word : res) {
			// if(word.equals("aab"))
			System.out.print(word + " ");
		}
		System.out.println();
		List<String> r = getCombination(s1, 2);
		for (String s : r) {
			System.out.print(s + " ");
		}
	}

	private static ArrayList<String> getPermutations(String s, int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 0 || s == null || s.length() < n || n <= 0)
			return res;
		int[] visited = new int[s.length()];
		char[] word = s.toCharArray();
		Arrays.sort(word);
		// System.out.print(new String(word)+" ");
		helper(word, n, new StringBuilder(), res, visited);
		return res;
	}

	private static void helper(char[] s, int n, StringBuilder sb, ArrayList<String> res, int[] visited) {
		if (sb.length() == n) {
			res.add(sb.toString());
			return;
		}
		for (int i = 0; i < s.length; i++) {
			if (visited[i] == 1 || i != 0 && s[i] == s[i - 1] && visited[i - 1] == 0)
				continue;
			sb.append(s[i]);
			visited[i] = 1;
			helper(s, n, sb, res, visited);
			sb.deleteCharAt(sb.length() - 1);
			visited[i] = 0;
		}

	}

	private static ArrayList<String> getCombination(String s, int n) {
		ArrayList<String> res = new ArrayList<String>();
		if (s.length() == 0 || s == null || s.length() < n || n <= 0)
			return res;
		int[] visited = new int[s.length()];
		char[] word = s.toCharArray();
		Arrays.sort(word);
		// System.out.print(new String(word)+" ");
		dfs(word, n, new StringBuilder(), res, visited, 0);
		return res;
	}

	private static void dfs(char[] s, int n, StringBuilder sb, ArrayList<String> res, int[] visited, int start) {
		if (sb.length() == n) {
			res.add(sb.toString());
			return;
		}
		for (int i = start; i < s.length; i++) {
			if (visited[i] == 1 || i != 0 && s[i] == s[i - 1] && visited[i - 1] == 0)
				continue;
			sb.append(s[i]);
			visited[i] = 1;
			dfs(s, n, sb, res, visited, i + 1);
			sb.deleteCharAt(sb.length() - 1);
			visited[i] = 0;
		}

	}

}
