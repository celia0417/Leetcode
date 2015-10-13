package Backtracking;

import java.util.*;

public class PermutationSequence {
	List<String> sol = new ArrayList<String>();

	public List<String> getPermutation(int n, int k) {
		StringBuffer str = new StringBuffer();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		helper(n, list, sol, 0, str, k);
		return sol;
	}

	public void helper(int n, List<Integer> list, List<String> sol, int cnt, StringBuffer str, int k) {
		if (cnt == n) {
			sol.add(str.toString());
			if (sol.size() >= k) {
				return;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			int x = list.remove(i);
			helper(n, list, sol, cnt + 1, str.append(x), k);
			str.deleteCharAt(str.length() - 1);
			list.add(i, x);
		}
	}

	public String getPermutation2(int n, int k) {
		List<Integer> num = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			num.add(i);
		int[] fact = new int[n]; // factorial
		fact[0] = 1;
		for (int i = 1; i < n; i++)
			fact[i] = i * fact[i - 1];
		k = k - 1;
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			int ind = k / fact[i];
			k = k % fact[i];
			sb.append(num.get(ind));
			num.remove(ind);
		}
		return sb.toString();
	}

	public static void main(String args[]) {
		PermutationSequence ps = new PermutationSequence();
		String res = ps.getPermutation2(3, 3);
		System.out.println(res);
	}
}
