package Array;

public class DuplicateNumber {
	public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i])] < 0) return Math.abs(nums[i]);
            else nums[Math.abs(nums[i])] = - nums[Math.abs(nums[i])];
        }
        throw new IllegalArgumentException("Wrong Input");
    }
	
	public static void main(String args[]){
		DuplicateNumber dn = new DuplicateNumber();
		int[] nums = {1,2,3,3};
		System.out.println(dn.findDuplicate(nums));
	}
}
