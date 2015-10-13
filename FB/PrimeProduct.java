package FB;

import java.util.*;

public class PrimeProduct {
	private List<Integer> res = new ArrayList<>();
	public List<Integer> subsets(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		helper(nums, 0, list);
		return res;
	}

	public void helper(int[] nums, int n, List<Integer> list) {
		if (!list.isEmpty()) {
			int sol = 1;
			for (int i : list) {
				sol *= i;
			}
			System.out.print(sol+" ");
			res.add(sol);
		}
		for (int i = n; i < nums.length; i++) {
			list.add(nums[i]);
			helper(nums, i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String args[]) {
		PrimeProduct pp = new PrimeProduct();
		int nums[] = { 2, 3, 5 };
		pp.subsets(nums);
	}
}
