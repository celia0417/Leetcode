package Zenefits;

public class DistinctSubsequences {
	
	public int numDistinct2(String s1, String s2) {
		int len1 = s1.length(), len2 = s2.length();
	       if (len2 > len1) return 0;
	       if (len2 == 0 || len2 %2 != 0) return 0;
	       // DP matches each pattern
	       // number of matches between s1.substring(0, i + 1) and s2.substring(j * 2, j * 2 + 2)
	       int[][] dp = new int[len1 + 1][len2 / 2 + 1];
	       // no match for dp[0][j]
	       for (int i = 1; i < len1; i++){
	           dp[i + 1][0] = 1;
	           for (int j = 0; j < len2 / 2; j++){
	               dp[i + 1][j + 1] = dp[i][j + 1];
	               if (isMatch(s1, s2, i, j)){
	                   if (s2.charAt(2*j + 1) == '+')
	                       dp[i + 1][j + 1] += dp[i - 1][j];
	                   else
	                       dp[i + 1][j + 1] += dp[i - 3][j];
	               }
	           }
	       }
	       return dp[len1][len2 / 2];
	}
	
	boolean isMatch(String s1, String s2, int i, int j){
	       char c = s2.charAt(j * 2);
	       char p = s2.charAt(j * 2 + 1);
	       int len = p == '+' ? 2 : 4;
	       if (i - len < -1) return false;
	       for (int h = i - len + 1; h <= i; h++){
	           if (s1.charAt(h) != c) return false;
	       }
	       return true;
	   }
	
	public static void main(String args[]) {
		DistinctSubsequences ds = new DistinctSubsequences();
//		System.out.println(
//				ds.numDistinct("waeginsapnaabangpisebbasepgnccccapisdnfngaabndlrjngeuiogbbegbuoecccc", "a+b+c-"));
//		
		System.out.println(
				ds.numDistinct2("waeginsapnaabangpisebbasepgnccccapisdnfngaabndlrjngeuiogbbegbuoecccc", "a+b+c-"));
	}
}
