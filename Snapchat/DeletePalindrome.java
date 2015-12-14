package Snapchat;

public class DeletePalindrome {
	public String delte(String s){
		int n = s.length();
        boolean[][] tab = new boolean[n][n];
        int maxLen = 0, leftIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                tab[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || tab[i + 1][j - 1]);
                if (tab[i][j] && (j - i + 1 > maxLen)) {
                	maxLen = j - i + 1;
                	leftIndex = i;
                }
            }
        }
        
        return s.substring(leftIndex, leftIndex  + maxLen);
	}
	
	public static void main(String args[]){
		DeletePalindrome dp = new DeletePalindrome();
		System.out.println(dp.delte("abxyyxc"));
	}
}
