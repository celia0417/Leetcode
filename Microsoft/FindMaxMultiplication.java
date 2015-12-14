package Microsoft;

public class FindMaxMultiplication {
	public int multiply(int[] nums) {
		if (nums == null || nums.length < 2)
			return -1;
		int max = nums[0], secMax = Integer.MIN_VALUE;
		int min = nums[0], secMin = Integer.MAX_VALUE;
		for (int i = 1; i < nums.length; i++) {
			// find the biggest numbers
			if (max < nums[i]) {
				int tmp = max;
				max = nums[i];
				secMax = tmp;
			} else {
				secMax = Math.max(secMax, nums[i]);
			}

			// find the two smallest numbers
			if (min > nums[i]) {
				int tmp = min;
				min = nums[i];
				secMin = tmp;
			} else {
				secMin = Math.min(secMin, nums[i]);
			}
		}
		return Math.max(min * secMin, max * secMax);
	}
	
	public static void main (String args[]){
		FindMaxMultiplication fmm = new FindMaxMultiplication();
		System.out.println(fmm.multiply(new int [] {-20,0,1}));
	}
}
