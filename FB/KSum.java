package FB;

import java.util.*;

public class KSum {

	private Set<Integer> visited = new HashSet<>();
    private List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> kSum(int[] nums, int target, int k) {
		if (nums == null || nums.length == 0)
			return res;
		Arrays.sort(nums);
		helper(nums, target, k, new ArrayList<Integer>(), 0);
		return res;
	}

	public void helper(int[] nums, int target, int k,  List<Integer> list, int index) {
		if (list.size() == k) {
			if (target == 0) {
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (i > 0 && !visited.contains(i - 1) && nums[i - 1] == nums[i])
				continue;
				list.add(nums[i]);
				visited.add(i);
				helper(nums, target - nums[i], k, list, i+1);
				list.remove(list.size() - 1);
				visited.remove(i);
		}
	}

	public static void main(String args[]) {
		KSum ksum = new KSum();
		int nums[] = { 1, 1, 2, 3, 4, 5, 6 };
		List<List<Integer>> res = ksum.kSum(nums, 15, 5);
		for (List<Integer> list : res) {
			for (int i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
