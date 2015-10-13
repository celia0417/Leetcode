package Tree;

import java.util.*;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || k < 1 || t < 0) return false;
		
		TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++){
            Integer ceilling = set.ceiling(nums[i] - t);
            Integer floor = set.floor(nums[i] + t); 
            if ((floor != null && floor >= nums[i]) || (ceilling != null && ceilling <= nums[i]))
            	return true;
            set.add(nums[i]);
            if (i >= k){
            	set.remove(nums[i-k]);
            }
            		
        }
        return false;
    }
	
	public static void main (String args[]){
		System.out.println(Integer.MAX_VALUE);
	}
}
