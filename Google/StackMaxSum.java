package Google;

public class StackMaxSum {
	public static int getmaxsum(int[][] nums, int k) {
		int[][] dp = new int[nums.length][k + 1];// the max sum using first i

		// array, and j numbers
		for (int j = 0; j <= k; j++) {
			for (int i = 0; i < dp.length; i++) {
				// dp[i][j] = max(dp[i-1][l] + sum{});
				dp[i][j] = Math.max(i - 1 >= 0 ? dp[i - 1][j] : 0, j - 1 >= 0 ? dp[i][j - 1] : 0);
				int len = nums[i].length;
				int sum = 0;
				for (int l = 0; j - l - 1 >= 0 && l < len; l++) {
					sum += nums[i][l];
					dp[i][j] = Math.max(dp[i][j], (i - 1 >= 0 ? dp[i - 1][j - l - 1] : 0) + sum);
				}

			}
		}

		return dp[nums.length - 1][k];
	}
	
	public static void main (String args[]){
		StackMaxSum sms = new StackMaxSum();
//		int [][] nums = int [][] {};
//		sms.getmaxsum(nums, k)
	}
}
