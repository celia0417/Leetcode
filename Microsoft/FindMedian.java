package Microsoft;


public class FindMedian {


	public int findKthLargest(int[] nums) {
		if (nums.length % 2 == 0)
			return (selectK(nums, 0, nums.length - 1, nums.length/2) + selectK(nums, 0, nums.length - 1, nums.length/2 + 1))/2;
		else 
			return selectK(nums, 0, nums.length - 1, nums.length/2 + 1);
	}
    
    public int selectK(int[] nums, int low, int high, int k){
        if (low == high) return nums[low];
        int p = partition(nums, low, high);
        int x = high - p + 1;
        if (x == k) return nums[p];
        else if (x < k) return selectK(nums, low, p - 1, k - x);
        else return selectK(nums, p + 1, high, k);
    }
    
    public int partition(int[] nums, int low, int high){
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++){
            if (nums[j] <= pivot){
                swap(nums, i, j);
                i ++;
            }
        }
        swap(nums, i, high);
        return i;
    }
    
    public void swap (int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String args[]) {
    	FindMedian kl = new FindMedian();
		int[] nums = new int[] { 4, 2, 100, 8, 1, 6, 9, 10, 20 };
		System.out.println(kl.findKthLargest(nums));
	}
}
