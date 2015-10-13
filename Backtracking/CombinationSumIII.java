package Backtracking;

import java.util.*;

public class CombinationSumIII {
	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> list = new ArrayList<>();
		List<Integer> nums = new ArrayList<>();
		for (int i = 1; i <= 9; i++)
			nums.add(i);
		helper(k, n, list, nums, 0);
		return res;
	}

	public void helper(int k, int n, List<Integer> list, List<Integer> nums, int sum) {
		if (list.size() == k && sum == n) {
			List<Integer> sol = new ArrayList<Integer>();
			for (int i : list) {
				sol.add(i);
			}
			res.add(sol);
		} else if (list.size() >= k && sum == n) {
			return;
		}

		for (int i = 0; i < nums.size(); i++) {
			if (list.isEmpty() || nums.get(i) > list.get(list.size() - 1)) {
				int x = nums.remove(i);
				list.add(x);
				helper(k, n, list, nums, sum + x);
				nums.add(i, x);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String args[]) {
		CombinationSumIII cs = new CombinationSumIII();
		List<List<Integer>> res = cs.combinationSum3(4, 15);
		for (List<Integer> l : res) {
			for (int i : l) {
				System.out.println(i);
			}
			System.out.println("/");
		}
	}
}
