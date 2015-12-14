package Zenefits;

import java.util.*;

public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            int temp = target - nums[i];
            int p = i + 1, q = nums.length-1;
            while (p < q){
                if (nums[p] + nums[q] < temp){
                    cnt += q - p;
                    p++;
                }else {
                    q--;
                }
            }
        }
        return cnt;
    }
	// X <= 100 * N (2 * max <= X )
}
