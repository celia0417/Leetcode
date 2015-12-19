package Bloomberg;

public class MoveZerosOne {
	public void move(int[] nums) {
		int l = 0, r = nums.length - 1;
		while (l < r) {
			if (nums[l] == 0)
				l++;
			if (nums[r] == 1)
				r--;
			if (nums[l] == 1 && nums[r] == 0 &&l < nums.length && r >= 0) {
				int temp = nums[l];
				nums[l] = nums[r];
				nums[r] = temp;
				l++;
				r--;
			}
		}
	}

	public static void main(String args[]) {
		MoveZerosOne mzo = new MoveZerosOne();
		int nums[] = new int[] { 1, 1, 0, 0, 1, 0, 0 };
		mzo.move(nums);
		for (int num : nums) {
			System.out.println(num);
		}
	}
}
