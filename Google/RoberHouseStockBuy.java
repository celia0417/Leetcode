package Google;

public class RoberHouseStockBuy {
	public int rob(int[] prices) {
		int dp[][] = new int[prices.length][prices.length];
		dp[0][0] = -prices[0];
		dp[0][1] = 0;

		for (int i = 1; i < prices.length; i++) {
			// Case 1: hold
			if (i == 1) {
				dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
			} else {
				dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][1] - prices[i]);
			}
			// Case 2: unhold
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
		}
		return dp[prices.length - 1][1];
	}

	public static void main(String args[]) {
		RoberHouseStockBuy rb = new RoberHouseStockBuy();
		System.out.println(rb.rob(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
	}
}
