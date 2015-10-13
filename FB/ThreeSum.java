package FB;

import java.util.*;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return res;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			int target = -num[i];
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				if (num[left] + num[right] <= target) {
					if (num[left] + num[right] == target) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(num[i]);
						list.add(num[left]);
						list.add(num[right]);
						res.add(list);
					}
					left++;
					while (left < right && num[left] == num[left - 1])
						left++;
				} else {
					right--;
					while (left < right && num[right] == num[right + 1])
						right--;
				}
			}
		}
		return res;
	}

	public boolean threeSum2(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num.length < 3)
			return false;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			int target = -num[i];
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				if (num[left] + num[right] <= target) {
					if (num[left] + num[right] == target) {
						return true;
					}
					left++;
					while (left < right && num[left] == num[left - 1])
						left++;
				} else {
					right--;
					while (left < right && num[right] == num[right + 1])
						right--;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		ThreeSum ts = new ThreeSum();
		int num[] = { 1, 2, 1, -3, 0, -4, 3, 2, 1 };
		int num2[] = { 0, 0, 0, 0 };
		List<List<Integer>> res = ts.threeSum(num);
		for (List<Integer> r : res) {
			for (int i : r) {
				System.out.println(i);
			}
		}
		System.out.println(ts.threeSum2(num));
	}
}
