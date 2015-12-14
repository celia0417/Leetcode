package Zenefits;

import java.util.*;

public class PrefixSurfixArray {

	public static long getPrefixSurfixPair(int[] a) {
		if (a == null || a.length == 0)
			return 0;
		int[] leftSetCount = new int[a.length];
		int[] rightSetCount = new int[a.length];
		int left = 0, right = 0;
		long result = 0;
		HashSet<Integer> diff = new HashSet<Integer>();
		HashSet<Integer> leftSet = new HashSet<Integer>();
		HashSet<Integer> rightSet = new HashSet<Integer>();
		HashSet<Integer> pairIndex = new HashSet<Integer>();
		while (left < a.length || right < a.length) {
			int temp = 0;
			if (leftSet.size() <= rightSet.size() && left < a.length) {
				temp = a[left];
				if (!leftSet.contains(temp)) {
					leftSet.add(temp);
					leftSetCount[leftSet.size() - 1] = 1;
					if (diff.contains(temp)) {
						diff.remove(temp);
					} else {
						diff.add(temp);
					}
				} else {
					leftSetCount[leftSet.size() - 1]++;
				}
				left++;
			} else {
				temp = a[a.length - 1 - right];
				if (!rightSet.contains(temp)) {
					rightSet.add(temp);
					rightSetCount[leftSet.size() - 1] = 1;
					if (diff.contains(temp)) {
						diff.remove(temp);
					} else {

					}
				} else {
					rightSetCount[rightSet.size() - 1]++;
				}
				right++;
			}
			if (diff.isEmpty() && !pairIndex.contains(leftSet.size())) {
				pairIndex.add(leftSet.size());
			}
		}
		for (Integer i : pairIndex) {
			result += leftSetCount[i - 1] * rightSetCount[i - 1];
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tests = { { 1, 1, 1 }, { 1, 2, 3, 1, 2 }, { 1, 2, 3, 4, 5 } };
		for (int[] test : tests) {
			System.out.println("The number of prefix-surfix pair for array " + Arrays.toString(test) + " is "
					+ getPrefixSurfixPair(test));
		}
	}

}
