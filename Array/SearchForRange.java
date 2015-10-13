package Array;

public class SearchForRange {
	public int[] searchRange(int[] nums, int target) {
        int res [] = {-1,-1};
        if (nums[0] == target)
        	res[0]=0;
        if (nums[nums.length-1] == target)
        	res[1] = nums.length-1;
        search (nums, target, 1, nums.length-2,res);
        if (res[0] != -1 && res[1] == -1)
        	res[1] = res[0];
        if (res[0] == -1 && res[1] != -1)
        	res[0] = res[1];
        return res;
    }
	
	public void search (int[] nums, int target, int l, int r, int res[]){
        while (l <= r ){
        	if (res[0] != -1 && res[1] != -1) {
            	return;
            }
            int mid = l + (r-l)/2;
            if (nums[mid] == target){
                if ( nums[mid-1] < target){
                    res[0] = mid;
                }else if ( nums[mid +1] > target){
                    res[1] = mid;  
                }
                if (l == r) break;
                search (nums,target, l, mid-1,res);
                search (nums,target, mid +1, r, res);
            }else if (nums[mid] < target){
            	l = mid +1;
            }else{
            	r = mid -1;
            } 
        }
	}
	
	public int[] searchRange2(int[] nums, int target) {
		int res [] = new int [2];
		res [0] = findRightMost(nums,nums.length, target);
		res [1] = findLeftMost(nums,nums.length, target);
		return res;
	}
	
    int findRightMost(int A[], int n, int target) {
    	int l = 0, r = n-1;
    	while (l <= r){
    		int mid = l + (r-l)/2;
    		if (A[mid] < target){
    			l = mid +1;
    		}else if (target < A[mid]){
    			r = mid -1;
    		}else{
    			l = mid +1;
    		}
    	}
    	if (r >= 0 && r < n && A[r] == target) return r;
    	return -1;
    }
    
    int findLeftMost(int A[], int n, int target) {
    	int l = 0, r = n-1;
    	while (l <= r){
    		int mid = l + (r-l)/2;
    		if (A[mid] < target){
    			l = mid +1;
    		}else if (target < A[mid]){
    			r = mid -1;
    		}else{
    			r = mid -1;
    		}
    	}
    	if (l >= 0 && l < n && A[l] == target) return l;
    	return -1;
    }

	
	public static void main (String argsp[]){
		SearchForRange sfr = new SearchForRange();
		int nums [] = {1,2,3};
		int res[] = sfr.searchRange2(nums, 2);
		for (int r : res){
			System.out.println(r);
		}
	}
}
