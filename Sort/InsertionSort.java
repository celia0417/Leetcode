package Sort;

public class InsertionSort {
	public static void insertionSort(int[] nums){
		for (int i = 1; i < nums.length; i++){
			int num = nums[i];
			int j = i-1;
			while (j >= 0 && nums[j] > num){
				nums[j+1] = nums[j--];
			}
			nums[j+1] =  num;
		}
	}
	
	public static void main (String args[]){
		int[] nums = {3,4,9,7,6,1};
		InsertionSort.insertionSort(nums);
		for (int num : nums)
			System.out.println(num);
	}
}
