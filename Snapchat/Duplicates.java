package Snapchat;

import java.util.*;

public class Duplicates {
	public int findDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int num : nums) {
			if (!set.contains(num))
				set.add(num);
			else
				return num;
		}
		return -1;
	}

	public int findDuplicate2(int[] nums) {
		int low = 1;
		int high = nums.length - 1;
		int mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			int count = 0;
			for (int i : nums) {
				if (i <= mid) {
					count++;
				}
			}
			if (count <= mid) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	public int findDuplicate3(int[] nums) {
		int slow = nums[0];
		int fast = nums[nums[0]];
		while(slow != fast){
			slow = nums[slow];
			fast = nums[nums[fast]];
		}
		slow = 0;
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
	
	public static void main(String args[]){
	}
}
