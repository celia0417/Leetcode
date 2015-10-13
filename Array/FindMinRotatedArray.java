package Array;

public class FindMinRotatedArray {
	public int findMin(int[] num) {
		int start =0, end = num.length-1;
		while (start < end){
		    int mid = start + (end-start)/2;
		    if (num[mid] > num[end])
		        start = mid +1;
		    else if (num[mid] < num[end])
		        end = mid;
		    else
		    	end--;
		}
		return num[start];
	}

	public static void main(String args[]) {
		FindMinRotatedArray fmra = new FindMinRotatedArray();
		int nums[] = {3,1,3};
		System.out.println(fmra.findMin(nums));
	}
}
