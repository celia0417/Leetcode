package Array;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				int minBigger = Integer.MAX_VALUE;
				int minIndex = 0;
				for (int j = nums.length - 1; j > i; j--) {
					if (nums[j] > nums[i] && nums[j] < minBigger) {
						minBigger = nums[j];
						minIndex = j;
					}
				}
				int temp = nums[i];
				nums[i] = nums[minIndex];
				nums[minIndex] = temp;
				Arrays.sort(nums, i +1, nums.length);
				return;
			}
		}

		Arrays.sort(nums, 0, nums.length);
	}

	public static void main(String args[]) {
		int nums[] = { 1, 2};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(nums);
	}
}
