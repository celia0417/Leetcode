package MS;

public class MoveZerosModification {
	public void moveZero(int[] nums, int n){
		int left = 0, right = nums.length - 1, i = 0;
		int halfN = n /2;
		while (i <= right){
			if (nums[i] == 0 && halfN-- > 0 ){
				swap(nums, i++, left);
				left ++;
			}
			else if (nums[i] == 0){
				swap(nums, i, right);
				right --;
			}else{
				i++;
			}
		}
	}
	
	public void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	
	public static void main (String args[]){
		MoveZerosModification mz = new MoveZerosModification();
		int nums[] = new int [] {3,4,5,0,2,0,5,6,7,0,3,0};
		mz.moveZero(nums, 4);
		for (int i : nums){
			System.out.print( i + " ");
		}
	}
}
