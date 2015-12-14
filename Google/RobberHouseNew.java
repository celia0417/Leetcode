package Google;

public class RobberHouseNew {
	public int rob(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[1], dp[0]);
		dp[2] = Math.max(nums[2], dp[1]);
		for (int i = 3; i < nums.length; i++){
			dp[i] = Math.max(dp[i-3] + nums[i], Math.max(dp[i-2], dp[i-1]));
		}
		return dp[nums.length -1];
	}
	
	public static void main (String args[]){
		RobberHouseNew rb = new RobberHouseNew();
		System.out.println(rb.rob(new int []{1,2,3,4,5,6,7}));
	}
}
