package Sort;

public class QuickSort {
	public void quickSort(int[] nums, int low, int high) {
        if (low < high){
            int p = partition (nums, low, high);
            quickSort(nums,low,p-1);
            quickSort (nums,p+1,high);
        }
    }
    
    public int partition (int[] nums, int low, int high){
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++){
            if (nums[j] <= pivot){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i ++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[high];
        nums[high]= temp;
        return i;
    }
}
