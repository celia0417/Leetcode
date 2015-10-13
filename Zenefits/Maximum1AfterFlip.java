package Zenefits;

import java.util.Scanner;

public class Maximum1AfterFlip {
	public int maximum1AfterFlip(int[] nums){
		int sum = 0;
		for (int i = 0; i < nums.length; i++){
			sum += nums[i];
			nums[i] = nums[i] == 0 ? 1 : -1;
		}
		int maxEnding = nums[0], maxSoFar = nums[0];  
		for (int i = 1; i < nums.length; i ++){
			maxEnding = Math.max(maxEnding + nums[i], nums[i]);
			maxSoFar = Math.max(maxEnding, maxSoFar);
		}
		return sum + maxSoFar;
	}
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		
		Maximum1AfterFlip maf = new Maximum1AfterFlip();
		int[] nums = {1, 0, 1, 0, 0, 1, 0, 1};
		System.out.println(maf.maximum1AfterFlip(nums));
	}
}
