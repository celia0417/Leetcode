package Backtracking;
import java.util.*;
public class Permutation {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	Set<Integer> visited = new HashSet<>();

	public List<List<Integer>> permuteUnique(int[] num) {
		if (num == null || num.length == 0)
			return res;
		Arrays.sort(num);
		helper(num, new ArrayList<Integer>(), num.length);
		return res;
	}

	public void helper(int[] num, List<Integer> list, int n) {
		if (list.size() == n) {
			res.add(new ArrayList<Integer>(list));
			return;
		}

		for (int i = 0; i < num.length; i++) {
			if (i > 0 && !visited.contains(i - 1) && num[i - 1] == num[i])
				continue;
			if (!visited.contains(i)) {
				list.add(num[i]);
				visited.add(i);
				helper(num, list, n);
				list.remove(list.size() - 1);
				visited.remove(i);
			}
		}
	}

	public static void main(String args[]) {
		Permutation p = new Permutation();
		int num[] = { 1, 1, 2 };
		List<List<Integer>> res = p.permuteUnique(num);
		for (List<Integer> list : res){
			for (int i : list){
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
