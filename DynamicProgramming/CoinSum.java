package DynamicProgramming;

import java.util.*;

public class CoinSum {
	// public int fun(int[] coins, int sum) {
	// if (coins == null || coins.length == 0)
	// return 0;
	// if (sum == 0)
	// return 0;
	// int[] mem = new int[sum + 1];
	// Arrays.fill(mem, Integer.MAX_VALUE);
	// for (int i = 0, nlen = coins.length; i < nlen; i++) {
	// for (int j = coins[i]; j <= sum; j++) {
	// mem[j] = Math.min(mem[j - coins[i]] + 1, mem[j]);
	// }
	// }
	// return mem[sum] == Integer.MAX_VALUE ? -1 : mem[sum];
	// }

	public List<List<Integer>> fun(int[] coins, int sum) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (coins == null || coins.length == 0)
			return ret;
		helper(ret, new ArrayList<Integer>(), coins, sum, 0);
		return ret;
	}

	private void helper(List<List<Integer>> ret, List<Integer> cur, int[] coins, int sum, int start) {
		if (sum == 0)
			ret.add(new ArrayList(cur));
		else {
			for (int i = 0, num = coins[start]; sum > 0; i++) {
				cur.add(i);
				helper(ret, cur, coins, sum, start + 1);
				cur.remove(cur.size());
				sum -= num;
			}
		}
	}

	public static void main(String args[]) {
		CoinSum cs = new CoinSum();
		System.out.println(cs.fun(new int[] { 2, 3, 5 }, 100));
	}
}
