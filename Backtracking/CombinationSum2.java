package Backtracking;

import java.util.*;

public class CombinationSum2 {
	private List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(candidates);
		Set<Integer> visited = new HashSet<Integer>();
		dfs(candidates, target, 0, list, visited);
		return res;
	}

	public void dfs(int[] candidates, int target, int n, List<Integer> list, Set<Integer> visited) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = n; i < candidates.length; i++) {
			if (target < 0)
				break;
			if (i > n && candidates[i] == candidates[i - 1])
				continue;
			int temp = candidates[i];
			list.add(candidates[i]);
			visited.add(candidates[i]);
			dfs(candidates, target - candidates[i], i + 1, list, visited);
			list.remove(list.size() - 1);
			visited.remove(temp);
		}
	}

	public static void main(String args[]) {
		CombinationSum2 cs2 = new CombinationSum2();
		List<List<Integer>> res = cs2.combinationSum2(new int[] { 2, 2, 2 }, 4);
		for (List<Integer> l : res) {
			for (int i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
