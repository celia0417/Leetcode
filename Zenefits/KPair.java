package Zenefits;

import java.util.Arrays;

public class KPair {
	public int countPairsWithDiffK (int[] arr,  int k){
		int n = arr.length;
		int count = 0;
	    Arrays.sort(arr);;  // Sort array elements
	 
	    int l = 0;
	    int r = 0;
	    while(r < n)
	    {
	         if(arr[r] - arr[l] == k)
	        {
	              while(l+ 1 < r && arr[l + 1] == arr[l]) {
	            	  l++;
	            	  count++;
	              }
	              while (r- 1 > l && arr[r] == arr[r -1]) {
	            	  r--;	
	            	  count ++;
	              }
	              l++;
	              r--;
	              count ++;
	        }
	         else if(arr[r] - arr[l] > k)
	              l++;
	         else // arr[r] - arr[l] < sum
	              r++;
	    }   
	    return count;
	}
	
	public static void main (String args[]){
		KPair kp = new KPair();
		System.out.println(kp.countPairsWithDiffK(new int [] {1, 5, 3, 4, 2,6,3}, 3));
	}
}
