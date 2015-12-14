package Google;

public class NumberOfSquares {
	public int count(char [][] matrix){
		int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int cnt = 0;
        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (matrix[i-1][j-1] == '1'){
                	cnt ++;
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                    if (dp[i][j] > 1) cnt ++;
                }
            }
        }
        return cnt;
	}
	
	public static void main (String args[]){
		NumberOfSquares ns = new NumberOfSquares();
		char [][] matrix = new char [][] {{'1','0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
		System.out.println(ns.count(matrix));
	}
}
