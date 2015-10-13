package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningII {
	List<List<String>> res = new ArrayList<List<String>>();

	public int minCut(String s) {
		List<String> list = new ArrayList<String>();
		List<Character> charList = new ArrayList<Character>();
		for (Character c : s.toCharArray()) {
			charList.add(c);
		}
		int min = Integer.MAX_VALUE;
		helper(list, s, 0);
		for (List<String> l : res) {
			if (l.size() - 1 < min) {
				min = l.size() - 1;
			}
		}
		return min;
	}

	public void helper(List<String> list, String str, int l) {
		if (list.size() > 0 && l == str.length()) {
			List<String> sol = new ArrayList<String>();
			for (String s : list) {
				sol.add(s);
			}
			res.add(sol);
		}

		for (int i = l; i < str.length(); i++) {
			if (isPalindrome(str.substring(l, i + 1))) {
				if (l == i) {
					list.add(Character.toString(str.charAt(l)));
				} else {
					list.add(str.substring(l, i + 1));
				}
				helper(list, str, i + 1);
				list.remove(list.size() - 1);
			}
		}
	}

	public boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public int minCut2(String s) {
		int n = s.length();
		int cut[] = new int[n+1]; // number of cuts for the first k characters
		for (int i = 0; i <= n; i++)
			cut[i] = i - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; i - j >= 0 && i + j < n && s.charAt(i-j) == s.charAt(i+j); j++) // odd
																					// length
																					// palindrome
				cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j]);

			for (int j = 1; i - j + 1 >= 0 && i + j < n && s.charAt(i - j + 1) == s.charAt(i + j); j++) // even
																							// length
																							// palindrome
				cut[i + j + 1] = Math.min(cut[i + j + 1], 1 + cut[i - j + 1]);
		}
		return cut[n];
	}

	public static void main(String args[]) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		int res = pp.minCut2("aab");
		System.out.println(res);
	}
}
