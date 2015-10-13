package DynamicProgramming;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m <= 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        int dp [][] = new int [m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }
}
