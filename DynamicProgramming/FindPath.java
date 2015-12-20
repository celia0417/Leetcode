package DynamicProgramming;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class FindPath {
	public int findPath(int m, int n, int[][] matrix) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) dp[i][j] = 0;
				else if (i == 0 || j == 0)
					dp[i][j] = 1;
				else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	
	public static void main (String args[]){
		FindPath fp = new FindPath();
		System.out.println(fp.findPath(3, 4, new int[][]{{1,1,1,0},{1,1,1,0},{1,0,1,1}}));
	}
}
