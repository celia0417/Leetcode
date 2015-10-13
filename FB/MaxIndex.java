package FB;

import java.util.Random;

public class MaxIndex {
	public int maxIndex(int[] nums) {
		int max = Integer.MIN_VALUE, cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
				cnt = 1;
			} else if (nums[i] == max) {
				cnt++;
			}
		}

		Random rn = new Random();
		int ran = rn.nextInt(cnt);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == max) {
				if (ran == 0)
					return i;
				ran--;
			}
		}
		return -1;
	}

	public int maxIndex2(int[] nums) {
		int res = -1, max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == max) {
				count++;
				int judge = (int) (Math.random() * count);
				if (judge == 0) {
					res = i;
				}
			} else if (nums[i] > max) {
				max = nums[i];
				res = i;
				count = 1;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		MaxIndex mi = new MaxIndex();
		int nums[] = { 2, 1, -1, 2, 1, -1, 2 };
		System.out.println(mi.maxIndex2(nums));
	}
}
