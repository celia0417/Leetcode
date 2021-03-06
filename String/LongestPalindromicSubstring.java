package String;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String t = preProcess(s);
		int n = t.length();
		if (n == 2)
			return s;
		int[] L = new int[n];
		int C = 0, R = 0;
		int max = 0, center = 0;
		
		for (int i = 1; i < n -1; i++){
			int iMirror = 2 * C -i;
			L[i] = i< R ? Math.min(L[iMirror], R-i):1;
			while(t.charAt(i - L[i]) == t.charAt(i + L[i]))  L[i]++;
			if (i + L[i] >R){
				C = i;
				R = i + L [i];
			}
			if (L[i] > max){
				max = L[i];
				center = i;
			}
		}
		int start = (center - max) /2, end = start + max -1;		
		return s.substring(start,end);
	}

	private String preProcess(String s) {
		int n = s.length();
		if (n == 0)
			return "^$";
		StringBuilder sb = new StringBuilder("^");
		for (int i = 0; i < n; i++) {
			sb.append("|").append(s.charAt(i));
		}
		sb.append("|$");
		return sb.toString();
	}
	
	public static void main (String args[]){
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome("abccbadgeg"));
	}
}
