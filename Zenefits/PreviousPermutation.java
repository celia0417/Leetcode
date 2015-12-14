package Zenefits;

public class PreviousPermutation {
	public void nextPermutation(int[] nums) {
        int cur = nums.length - 1;
        while(cur > 0 && nums[cur - 1] <= nums[cur]) cur --;
        reverse(nums, cur, nums.length - 1);
        if (cur > 0){
            int next = cur;
            cur--;
            while (nums[cur] <= nums[next]) next ++;
            swap(nums, cur, next);
        }
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start ++, end --);
        }
    }
    
    private void swap (int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    public static void main (String args[]){
    	PreviousPermutation pp = new PreviousPermutation();
//    	int [] nums = new int []{4,5,7,1,2,3,6};
    	int [] nums = new int []{1,3,2};
    	pp.nextPermutation(nums);
    	for (int num : nums){
    		System.out.print(num + " ");
    	}
    }
}
