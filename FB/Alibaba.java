package FB;

public class Alibaba {
	public boolean alibaba(int numCaves, int[] strategy) {
		int days = strategy.length;
		boolean[][] res = new boolean[numCaves][days + 1];
		for (int i = 0; i < days; i++) {
			res[strategy[i]][i + 1] = true;
		}

		for (int j = days; j >= 1; j--) {
			for (int i = 0; i < numCaves; i++) {
				if (res[i][j])
					continue;
				res[i][j] = true;
				if (i < numCaves - 1)
					res[i][j] = res[i][j] && res[i + 1][j + 1];
				if (i > 0)
					res[i][j] = res[i][j] && res[i - 1][j + 1];
			}
		}

		boolean result = true;
		for (int i = 0; i < numCaves && result; i++) {
			result = result && res[i][1];
		}

		return result;
	}
}
