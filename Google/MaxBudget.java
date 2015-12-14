package Google;

public class MaxBudget {
	public int max(int[][] sum, int target) {
		int m = sum.length, n = sum[0].length;
		int max = 0;
		for (int j1 = 0; j1 < m; j1++) {
			int[] temp = new int[n];
			for (int j2 = j1; j2 < m; j2++) {
				for (int i = 0; i < n; i++) {
					temp[i] += sum[j2][i];
				}
				int tempMax = findMaxLengthIn1DArray(temp, target);
				max = Math.max(max, tempMax * (j2 - j1 + 1));
			}
		}
		return max;
	}

	private int findMaxLengthIn1DArray(int[] nums, int target) {
		int max = 0, i = 0, sta = 0, sum = 0;
		while (i < nums.length) {
			sum += nums[i];
			if (sum <= target) {
				max = Math.max(max, i - sta + 1);
			}
			while (sum > target) {
				sum -= nums[sta++];
			}
			i++;
		}
		return max;
	}
	
	public static void main (String args[]){
		MaxBudget mb = new MaxBudget();
		System.out.println(mb.max(new int [][] {{1,2,3},{4,5,6},{7,8,9}}, 100));
	}
}
