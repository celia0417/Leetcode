package TwoPointers;

import java.util.*;

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0){
            return new int []{};
        }
        int n = nums.length;
        int [] r = new int [n - k + 1];
        int ri = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++){
        	if (!queue.isEmpty() && queue.peek() < i - k +1){
            	queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
            	queue.pollLast();
            }
            queue.offer(i);
            if ( i >= k -1){
            	r[ri++] = nums[queue.peek()];
            }
        }
        return r;
    }
	
	public static void main(String args[]){
		MaxSlidingWindow msw = new MaxSlidingWindow();
		int nums [] = {3,1,-1,-3,5,3,6,7};
		msw.maxSlidingWindow(nums, 3);
	}
}
