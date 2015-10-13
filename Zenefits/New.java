package Zenefits;

import java.util.*;

public class New {
	public int countNum(int[] A, int N) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int v : A)
			set.add(v);
		int[] B = new int[set.size()];
		int k = 0;
		for (int v : set)

		{
			B[k++] = v;
		}

		long count = 0;
		long sign = -1;
		for (int i = 0; i < B.length; i++)

		{
			sign = -sign;
			count += getInclExcl(B, N, i + 1) * sign;
		}
		return (int) (N - count);

	}

	private static long getInclExcl(int[] arr, int num, int subsetSize) {
		List<Set<Integer>> list = getAllSubset(arr, subsetSize);
		long count = 0;

		for (Set<Integer> set : list) {
			long lcm = getLCMFromSet(set);
			if (lcm >= 0)
				count += num / lcm;
		}
		return count;
	}

	private static List<Set<Integer>> getAllSubset(int[] arr, int subsetSize) {
		List<Set<Integer>> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		getAllSubsetRec(arr, 0, list, set, subsetSize);
		return list;
	}

	private static void getAllSubsetRec(int[] arr, int i, List<Set<Integer>> list, Set<Integer> set, int setSize) {
		if (set.size() == setSize) {
			list.add(new HashSet<>(set));
			return;
		}
		if (i == arr.length) {
			return;
		}
		set.add(arr[i]);
		getAllSubsetRec(arr, i + 1, list, set, setSize);
		set.remove(arr[i]);
		getAllSubsetRec(arr, i + 1, list, set, setSize);
	}

	private static long getLCMFromSet(Set<Integer> set) {

		long result = 1;
		for (int cur : set) {
			result = getLCMOfTwoNum(cur, result);
			if (result > Integer.MAX_VALUE)
				return -1;
		}
		return result;
	}

	private static long getLCMOfTwoNum(long a, long b) {

		return a * (b / getGCD(a, b));
	}
	
	private static long getGCD(long a, long b){
		if (b == 0)
			return a;
		return getGCD(b, a % b);
	}
}
