package Array;

public class SingleNumber3 {
	public int[] signleNumber(int[] nums) {
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		diff &= -diff;
		int res[] = { 0, 0 };
		for (int num : nums) {
			if ((num & diff) == 0) {
				res[0] ^= num;
			} else {
				res[1] ^= num;
			}
		}
		return res;
	}

	public static void main(String args[]) {
		SingleNumber3 sn3 = new SingleNumber3();
		int nums[] = { 1, 1, 2, 2, 3, 4 };
		for (int x : sn3.signleNumber(nums)) {
			System.out.println(x);
		}
		System.out.println(4 & -4);
		System.out.println(~(2 - 1));
	}
}
