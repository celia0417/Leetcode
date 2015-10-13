package DynamicProgramming;

import java.util.*;

public class WordBreak2 {
//	List<String> res = new ArrayList<>();
//
//	public List<String> wordBreak(String s, Set<String> wordDict) {
//		int n = s.length();
//		boolean dp[] = new boolean[n + 1];
//		dp[0] = true;
//		boolean[][] sub = new boolean[n + 1][n];
//		for (int j = 1; j <= s.length(); j++) {
//			for (int i = 0; i < j; i++) {
//				if (dp[i] && wordDict.contains(s.substring(i, j))) {
//					dp[j] = true;
//					sub[j][i] = true;
//				}
//			}
//		}
//		if (dp[n])
//			helper(s, wordDict, sub, 0, "");
//		return res;
//	}
//
//	public void helper(String s, Set<String> wordDict, boolean[][] sub, int n, String str) {
//		if (n == s.length()) {
//			res.add(str.trim());
//			return;
//		}
//		for (int i = n + 1; i <= s.length(); i++) {
//			if (sub[i][n]) {
//				String temp = str;
//				str += s.substring(n, i) + " ";
//				helper(s, wordDict, sub, i, str);
//				str = temp;
//			}
//		}
//	}
//	
	// better way
	List<String> res2 = new ArrayList<String>();
    public List<String> wordBreak2(String s, Set<String> wordDict) {
        int n = s.length();
        boolean dp [] = new boolean [n + 1];
        dp [0] = true;
        for (int j = 1; j <= n; j ++){
            for (int i = 0; i <= j; i ++){
                dp[j] = dp[i] && wordDict.contains(s.substring(i, j));
                if (dp[j]) break;
            }
        }
        if (!dp[n]) return res;
        dfs(s, wordDict, new StringBuilder(), 0);
        return res2;
    }
    
    public void dfs(String s, Set<String> wordDict, StringBuilder sol, int i){
        if (i == s.length()){
            res2.add(sol.toString());
        }
        for (int j = 1 + i; j <= s.length(); j++){
            if (wordDict.contains(s.substring(i, j))){
            	int len = sol.length();
                sol.append(s.substring(i, j));
                if (j != s.length()) sol.append(" "); 
                dfs(s, wordDict, sol, j);
                sol.delete(len, sol.length());
            }
        }
    }

	List<String> res = new ArrayList<String>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
       int n = s.length();
       boolean[] dp = new boolean[n + 1];
       dp[0] = true;
       for (int j = 1; j <= n; j ++){
           for (int i = 0; i < j; i++){
               dp[j] = dp[i] && wordDict.contains(s.substring(i, j));
               if (dp[j]) break;
           }
       }
       if (!dp[n]) return res;
       helper(s, wordDict, 0, new StringBuilder());
       return res;
    }
    
    public void helper(String s, Set<String> wordDict, int n, StringBuilder str){
        if (s.length() == n){
            res.add(str.toString());
        }
        for (int i = n + 1; i <= s.length(); i++){
        	String word = s.substring(n, i);
            if (wordDict.contains(word)){
            	int len = str.length();
            	str.append(word);
                if (i != s.length()) str.append(" ");
                helper(s, wordDict, i, str);
                str.delete(len, str.length());
            }
        }
    }
	public static void main(String args[]) {
		WordBreak2 wb2 = new WordBreak2();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");

		List<String> res = wb2.wordBreak("catsanddog", wordDict);
		for (String str : res) {
			System.out.println(str);
		}
	}
}
