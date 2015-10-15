package Snapchat;

public class FindMaximum {

	int findMax(int matrix[][]) {
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				MaxLength(i, j, matrix, dp, m, n);
			}
		}
		int max = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (max < dp[i][j]) {
					max = dp[i][j];
				}
			}
		}
		return max;
	}

	// dp[i][j] = max(dp[i-1][j], dp[i+1][j], dp[i][j-1], dp[i][j+1]) + 1
	int MaxLength(int i, int j, int matrix[][], int[][] dp, int m, int n) {
		if (dp[i][j] > 0)
			return dp[i][j];
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		if (i - 1 >= 0 && matrix[i][j] > matrix[i - 1][j]) {
			a = MaxLength(i - 1, j, matrix, dp, m, n);
		}
		if (i + 1 < m && matrix[i][j] > matrix[i + 1][j]) {
			b = MaxLength(i + 1, j, matrix, dp, m, n);
		}
		if (j - 1 >= 0 && matrix[i][j] > matrix[i][j - 1]) {
			c = MaxLength(i, j - 1, matrix, dp, m, n);
		}
		if (j + 1 < n && matrix[i][j] > matrix[i][j + 1]) {
			d = MaxLength(i, j + 1, matrix, dp, m, n);
		}
		return dp[i][j] = Max(a, b, c, d) + 1;
	}

	int Max(int a, int b, int c, int d) {
		int max1 = (a > b) ? a : b;
		int max2 = (c > d) ? c : d;
		return (max1 > max2) ? max1 : max2;
	}

	public static void main(String args[]) {
		FindMaximum fm = new FindMaximum();
		int matrix[][] = {{0,1,2},{0,3,4},{0,7,8}};
		System.out.println(fm.findMax(matrix));
	}

}
