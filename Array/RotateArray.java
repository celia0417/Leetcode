package Array;

public class RotateArray {
	public void rotate(int[] nums, int k) {
		if (k == 0 || nums.length == 0)
			return;
		int next = 0, cycle = 0, pre = nums[next], length = nums.length;
		for (int num : nums) {
			next = next + k >= length ? (next + k) % length : next + k;
			int temp = nums[next];
			nums[next] = pre;
			pre = temp;
			if (cycle == next && cycle < length - 1) {
				next++;
				cycle = next;
				pre = nums[next];
			}
		}
	}

	public void rotate2(int[] nums, int k) {
		int end = nums.length;
		k = k % end;// to check for outofbounds when k >= nums.length
		rotate(nums, 0, end - k - 1);// reverse one half of the array
		rotate(nums, end - k, end - 1);// reverse other half of the array
		rotate(nums, 0, end - 1);// reverse whole array
	}

	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public void rotate(int[] nums, int start, int end) {
		for (int i = start; i <= (start + end) / 2; i++) {
			swap(nums, i, (start + end) - i);
		}
	}

	public static void main(String args[]) {
		RotateArray ra = new RotateArray();
		int nums[] = { 1, 2, 3, 4, 5};
		// ra.rotate(nums, 2);
		ra.rotate2(nums, 2);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
