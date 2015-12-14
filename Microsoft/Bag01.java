package Microsoft;

public class Bag01 {
	public int knap(int[] p, int [] w, int m){
		int n = p.length;
		int dp[][] = new int [n + 1][m + 1];

		for (int j = 1; j < m + 1 ; j ++){
			for (int i = 1; i < n + 1; i ++){
				if (j < w[i - 1]){
					dp[i][j] = dp[i - 1][j];
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - w[i -1]] + p[i-1]);
				}
			}
		}
		return dp[n][m];
	}
	
	public static void main (String args[]){
		Bag01 bg = new Bag01();
		System.out.println(bg.knap(new int [] {4,5,6}, new int [] {3,4,5}, 10));
	}
}
