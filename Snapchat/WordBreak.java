package Snapchat;

import java.util.*;

public class WordBreak {
	Map<String,String> map = new HashMap<>();
	Map<String, String> table = new Hashtable<>();
	// bottom-up
	public boolean wordBreak3(String s, Set<String> wordDict) {
		int n = s.length();
		boolean dp[] = new boolean[n + 1];
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

	// print the first valid
	public String wordBreak(String s, Set<String> wordDict) {
		List<Integer> list = new ArrayList<Integer>(2);
		int n = s.length();
		int dp [] = new int [n + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		int pre = 0;
		for (int j = 1; j <= s.length(); j++) {
			for (int i = 0; i < j; i++) {
				if (dp[i] != -1 && wordDict.contains(s.substring(i, j))) {
					dp[j] = pre;
					pre = j;
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < dp.length; i++){
			if ( i  > 0 && dp[i] != -1){
				sb.append(s.substring(dp[i], i));
				if (i != dp.length-1) sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		WordBreak wb = new WordBreak();
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("co");
		wordDict.add("de");

		System.out.println(wb.wordBreak(s, wordDict));
	}
}
