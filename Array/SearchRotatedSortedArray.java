package Array;

public class SearchRotatedSortedArray {
	public boolean search(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;

			if (target == nums[mid])
				return true;

			if (nums[start] < nums[mid]) {
				if (target >= nums[start] && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else{
				if (target >= nums[mid] && target < nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		SearchRotatedSortedArray srsa = new SearchRotatedSortedArray();
		int nums[] = { 1, 3, 1, 1, 1 };
		System.out.println(srsa.search(nums, 3));
	}
}
