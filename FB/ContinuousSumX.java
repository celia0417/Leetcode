package FB;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSumX {
	// all positive
	public boolean sumX(int nums[], int X) {
		int start = 0, sum = 0;
		for (int end = 0; end < nums.length; end++) {
			sum += nums[end];
			while (start <= end && sum > X) {
				sum -= nums[start];
				start++;
			}
			if (sum == X) {
				return true;
			}
			if (start > end) {
				end = start;
			}
		}
		return false;
	}

	// dp
	public boolean sumXWithNegative(int nums[], int X) {
		int dp[] = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			dp[i] = nums[i];
			if (X == dp[i]) {
				return true;
			}
		}

		for (int i = 1; i < nums.length; i++) {
			int index = 0;
			for (int j = i; j < nums.length; j++) {
				dp[index] += nums[j];
				if (dp[index] == X) {
					return true;
				}
				index++;
			}
		}
		return false;
	}

	// brute force
	public boolean sumXWithNegative2(int nums[], int X) {
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == X)
					return true;
			}
		}
		return false;
	}

	// set
	public boolean sumXWithNegative3(int nums[], int X) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == X || set.contains(sum - X))
				return true;
			set.add(sum);
		}
		return false;
	}

	public static void main(String args[]) {
		ContinuousSumX csx = new ContinuousSumX();
		int nums[] = { -2, 3, -4, 0, 6, 99, 100 };
		System.out.println(csx.sumXWithNegative3(nums, 103));
	}
}
