package Array;

import java.util.*;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return res;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i+1 && nums[j] == nums[j - 1])
					continue;
				int lookfor = target - nums[i] - nums[j];
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if (nums[left] + nums[right] <= lookfor) {
						if (nums[left] + nums[right] == lookfor) {
							List<Integer> list = new ArrayList<Integer>();
							list.add(nums[i]);
							list.add(nums[j]);
							list.add(nums[left]);
							list.add(nums[right]);
							res.add(list);
						}
						left++;
						while (left < right && nums[left] == nums[left - 1])
							left++;
					} else {
						right--;
						while (left < right && nums[right] == nums[right + 1])
							right--;
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String args[]) {
		FourSum fs = new FourSum();
		int num[] = { 1,0,-1,0,-2,2 };
//		int num2[] = { 0, 0, 0, 0 };
		List<List<Integer>> res = fs.fourSum(num,0);
		for (List<Integer> r : res) {
			System.out.print("[");
			for (int i : r) {
				System.out.print(i+" ");
			}
			System.out.println("]");
		}
	}
}
