package FB;

public class MedianElementUnsortedArray {
	public int findKthLargest(int[] nums) {
		return selectK(nums, 0, nums.length - 1, nums.length / 2);
	}

	public int selectK(int[] nums, int low, int high, int k) {
		if (low == high)
			return nums[low];
		int pivot = pivot (nums, low, high);
		int p = partition(nums, low, high,pivot);
		if (p == k)
			return nums[p];
		else if (p < k)
			return selectK(nums, p + 1, high, k - p);
		else
			return selectK(nums, low, p - 1, k);
	}

	public int partition(int[] nums, int low, int high, int pivotIndex) {
		int pivot = nums[pivotIndex];
		int i = low;
		for (int j = low; j < high; j++) {
			if (nums[j] <= pivot) {
				swap(nums, i, j);
				i++;
			}
		}
		swap(nums, i, high);
		return i;
	}
	
	public int pivot(int[] nums, int left, int right){
		if (right - left < 5){
			return partition(nums,left,right,0);
		}
		return 0;
	}
	

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
