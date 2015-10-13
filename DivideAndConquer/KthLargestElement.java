package DivideAndConquer;

public class KthLargestElement {
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, k);
	}

	public int quickSelect(int[] nums, int low, int high, int k) {
		if (low == high)
			return nums[low];
		int p = partition(nums, low, high);
		int x = p - low +1;
		if (x == k) return nums[p];
		else if (k < x)
			return quickSelect(nums, low, p - 1, k);
		else
			return quickSelect(nums, p + 1, high, k);

	}

	public int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low;
		for (int j = low; j < high; j++) {
			if (nums[j] <= pivot) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		int temp = nums[i];
		nums[i] = nums[high];
		nums[high] = temp;
		return i;
	}
}
