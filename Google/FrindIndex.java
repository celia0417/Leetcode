package Google;

public class FrindIndex {
	public int searchIndex(int[] nums){
		int start = 0, end = nums.length - 1;
		while (start <= end){
			int mid = start + (end - start) /2;
			if (nums[mid] == mid){
				return mid;
			}else if (nums[mid] < mid){
				start = mid + 1; 
			}else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main (String args[]) {
		FrindIndex fi = new FrindIndex();
		int[] nums = new int [] {0,4,8,9,10,11,12,19};
		System.out.println(fi.searchIndex(nums));
	}
}
