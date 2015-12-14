package Microsoft;
/**
 * Add operations "+" and "*"
 * @author weixinwu
 *
 */
public class MinMax {
	public int getMax(int[] arr) {
		// arr has no negative integers
		int n = arr.length;
		int[][] res = new int[n][n];
		for (int i = 0; i < n; i++) {
			res[i][i] = arr[i];
		}
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				for (int k = i; k < j; k++) {
					res[i][j] = Math.max(res[i][j], Math.max(res[i][k] + res[k+1][j], res[i][k] * res[k+1][j]));
				}
			}
		}
		return res[0][n-1];
	}
	public int getMaxWithNega(int[] arr) {
		int n = arr.length;
		int[][] max = new int[n][n];
		int[][] min = new int[n][n];
		for (int i = 0; i < n; i++) {
			max[i][i] = arr[i];
			min[i][i] = arr[i];
		}
		for (int len = 2; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = i + len - 1;
				for (int k = 0; k < j; k++) {
					max[i][j] = Math.max(max[i][j], Math.max(max[i][k] + max[k+1][j], max[i][k] * max[k+1][j]));
					max[i][j] = Math.max(max[i][j], min[i][k] * min[k+1][j]);
					min[i][j] = Math.min(min[i][j], Math.min(min[i][k] + min[k+1][j], min[i][k] * min[k+1][j]));
					min[i][j] = Math.min(min[i][j], Math.min(min[i][k] * max[k+1][j], max[i][k] * min[k+1][j]));
				}
			}
		}
		return max[0][n-1];
	}
	public static void main(String[] args) {
		MinMax minMax = new MinMax();
		System.out.println(minMax.getMax(new int[]{-1, 1,1,2,1,1}));
		System.out.println(minMax.getMaxWithNega(new int[]{-1,-1,-2,1,1}));
	}
}
