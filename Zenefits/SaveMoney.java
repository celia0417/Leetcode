package Zenefits;

import java.util.*;

public class SaveMoney {
	public static int goThruMatrix(int[][] matrix, int k) {
		List<List<Integer>> leftMoney = new ArrayList<List<Integer>>();
		int m = matrix.length;
		int n = matrix[0].length;
		int curr = k;
		for (int j = 0; j < n; j++) {
			curr -= matrix[0][j];
			List<Integer> list = new ArrayList<>();
			if (curr > 0) {
				list.add(curr);
			}
			leftMoney.add(list);
		}
		for (int i = 1; i < m; i++) {
			if (leftMoney.get(0).get(0) - matrix[0][i] > 0) {
				leftMoney.get(0).set(0, leftMoney.get(0).get(0) - matrix[i][0]);
			} else {
				leftMoney.get(0).remove(0);
			}
			for (int j = 1; j < n; j++) {
				// from upper side
				for (int x = leftMoney.get(j).size() - 1; x >= 0; x--) {
					int tmp = leftMoney.get(j).get(x) - matrix[0][j];
					if (tmp > 0)
						leftMoney.get(j).set(x, tmp);
					else
						leftMoney.get(j).remove(x);
				}
				// from left side
				for (int x = leftMoney.get(j - 1).size() - 1; x >= 0; x--) {
					int tmp = leftMoney.get(j - 1).get(x) - matrix[0][j];
					if (tmp > 0)
						leftMoney.get(j).add(tmp);
				}
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < leftMoney.get(n - 1).size(); i++) {
			res = Math.min(res, leftMoney.get(n - 1).get(i));
		}
		return res == Integer.MAX_VALUE ? -1 : res;
	}

	public int findMaxSpent(int[][] mat, int k) {
		// dp[i][j][n] is the max mount spent at i,j but less than n
		// dp[i][j][n] = max(dp[i - 1][j][n - mat[i][j]], dp[i][j - 1][n -
		// mat[i][j]])
		int m = mat.length;
		if (m == 0)
			return -1;
		int n = mat[0].length;
		int[][] dp1 = new int[n + 1][k + 1];
		int[][] dp2 = new int[n + 1][k + 1];
		// when i == -1; edge case
		for (int j = 0; j < n; j++) {
			for (int h = 0; h <= k; h++) {
				dp1[j + 1][h] = -1;
			}
		}
		// when j = -1 edge case
		for (int h = 0; h <= k; h++) {
			dp2[0][h] = -1;
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int h = 0; h <= k; h++) {
					if (i == 0 && j == 0)
						dp2[j + 1][h] = 0;
					else if (h < mat[i][j])
						dp2[j + 1][h] = -1;
					else {
						int pre1 = dp2[j][h - mat[i][j]];
						int pre2 = dp1[j + 1][h - mat[i][j]];
						if (pre1 == -1 && pre2 == -1)
							dp2[j + 1][h] = -1;
						else
							dp2[j + 1][h] = Math.max(pre1, pre2) + mat[i][j];
					}
				}
			}
			dp1 = Arrays.copyOf(dp2, n + 1);
		}
		return dp1[n][k];
	}

	public static void main(String[] args) {
		SaveMoney sln = new SaveMoney();
		int[][] mat = { { 0, 4, 5 }, 
						{ 1, 3, 2 }, 
						{ 0, 1, 1 } };
		System.out.println(sln.goThruMatrix(mat, 12));
//		System.out.println(sln.goThruMatrix(mat, 12));

	}
}
