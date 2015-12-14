package Google;

public class MedianTwoSortedArrays {
	public double findMedianSortedArrays(int A[], int B[]) {
	    int m = A.length, n = B.length, mid = (m + n)/2;
	    boolean even = ((m + n) & 1) == 0;
	    // left and right use to find the median of A[] 
	    // (m < n: left = 0, right = m - 1; m > n: left = mid - n, right = mid)
	    int left = Math.max(0, mid - n), right = Math.min(m - 1, mid);
	    while (left <= right) { // binary search in A[]
	        int i = (left + right) / 2, j = mid - 1 - i;        
	        if      (j >= 0 && A[i] < B[j])      // if A[i]<median, get a larger A[i] (increase left)
	            left = i + 1;
	        else if (j < n - 1 && A[i] > B[j + 1])  // if A[i]>median, get a smaller A[i] (decrease right)  
	            right = i - 1;  
	        else {                                  // if B[j] <= A[i] <= B[j+1], median is found
	            if      (!even)             // m+n is odd, return A[i]
	                return A[i];                                    
	            else if (j < 0 || j >= n)   // m+n is even, the search of B[] is finished
	                return (A[i] + A[i - 1])/2.0;                   
	            else if (i == 0)            // m+n is even, the search of A[] is finished
	                return (A[i] + B[j])/2.0;                       
	            else                        // m+n is even, both A[] and B[] haven't finished search
	                return (A[i] + Math.max(B[j], A[i - 1]))/2.0;   
	        }
	    }
	    return findMedianSortedArrays(B, A); // binary search in B[] when the search of A[] is finished
	}
	
	public static void main (String args[]){
		MedianTwoSortedArrays mts = new MedianTwoSortedArrays();
		mts.findMedianSortedArrays(new int [] {4,5,6,7,8,9}, new int [] {1,2});
	}
}
