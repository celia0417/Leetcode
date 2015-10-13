package DynamicProgramming;

public class PaintHouse2 {
	public int minCostII(int[][] costs) {
		if (costs.length == 0)
			return 0;
		for (int i = 1; i < costs.length; i++) {
			for (int j = 0; j < costs[0].length; j++) {
				int min = Integer.MAX_VALUE;
				for (int z = 0; z < costs[0].length; z++) {
					if (costs[i - 1][z] < min && z != j) {
						min = costs[i - 1][z];
					}
				}
				costs[i][j] += min;
			}
		}
		int min = Integer.MAX_VALUE, n = costs.length - 1;
		for (int i = 0; i < costs[0].length; i++) {
			if (costs[n][i] < min)
				min = costs[n][i];
		}
		return min;
	}

	public int minCostII2(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;

		int n = costs.length, k = costs[0].length;
		// min1 is the index of the 1st-smallest cost till previous house
		// min2 is the index of the 2nd-smallest cost till previous house
		int min1 = -1, min2 = -1;

		for (int i = 0; i < n; i++) {
			int last1 = min1, last2 = min2;
			min1 = -1;
			min2 = -1;

			for (int j = 0; j < k; j++) {
				if (j != last1) {
					// current color j is different to last min1
					costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
				} else {
					costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
				}

				// find the indices of 1st and 2nd smallest cost of painting
				// current house i
				if (min1 < 0 || costs[i][j] < costs[i][min1]) {
					min2 = min1;
					min1 = j;
				} else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
					min2 = j;
				}
			}
		}

		return costs[n - 1][min1];
	}

	public static void main(String args[]) {
		PaintHouse2 ph2 = new PaintHouse2();
		int[][] costs = { { 1, 2, 4, 3 }, { 3, 4, 5, 7 }, { 9, 8, 3, 4 } };
		System.out.println(ph2.minCostII2(costs));
	}
}
