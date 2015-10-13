package Snapchat;

import java.util.*;

public class WordBreak {
	// recursion O(2^n)
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s.length() == 0)
			return true;
		for (int i = 0; i <= s.length(); i++) {
			String preString = s.substring(0, i);
			String laterString = s.substring(i, s.length());
			if (wordDict.contains(preString) && wordBreak(laterString, wordDict))
				return true;
		}
		return false;
	}

	// top-down
	public boolean wordBreak2(String s, Set<String> wordDict) {
		Map<String, Integer> map = new HashMap<>();
		return helper(s, wordDict, map);
	}

	public boolean helper(String s, Set<String> wordDict, Map<String, Integer> map) {
		if (s.length() == 0)
			return true;
		if (map.containsKey(s) && map.get(s) == 1)
			return true;
		else if (map.containsKey(s) && map.get(s) == -1)
			return false;

		for (int j = 0; j <= s.length(); j++) {
			String preString = s.substring(0, j);
			String laterString = s.substring(j, s.length());
			boolean result = wordDict.contains(preString) && helper(laterString, wordDict, map);
			if (result) {
				map.put(s, 1);
				return true;
			} else {
				map.put(s, -1);
			}
		}
		return false;
	}

	// bottom-up
	public boolean wordBreak3(String s, Set<String> wordDict) {
		int n = s.length();
		boolean dp [] = new boolean [n + 1];
		dp[0] = true;
		for (int j = 1; j <= s.length(); j++) {
			for (int i = 0; i < j; i++) {
				if (dp[i] && wordDict.contains(s.substring(i, j))) {
					dp[j] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public static void main(String args[]) {
		WordBreak wb = new WordBreak();
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("co");
		wordDict.add("de");

		System.out.println(wb.wordBreak3(s, wordDict));
	}
}
