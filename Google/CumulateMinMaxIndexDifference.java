package Google;

import java.util.Arrays;

public class CumulateMinMaxIndexDifference {
	public int[] returnMaxDif(int[] nums){ 
		int len = nums.length;
		int res[] = new int [2];
		Arrays.fill(res, -1);
		int[] culMin = new int [len];
		int minSoFar = Integer.MAX_VALUE;
		for (int i = 0; i < len; i++){
			if (nums[i] < minSoFar){
				minSoFar = nums[i];
			}
			culMin[i] = minSoFar;
		}
		
		int max = 0;
		for (int i = len -1; i >= 0; i--){
			int target = nums[i];
			int left = 0, right = i - 1;
			while (left <= right){
				int mid = left + (right - left)/2;
				if (culMin[mid] >= target){
					left = mid + 1;
				} else {
					right = mid - 1;
					if (i - mid + 1 > max) {
						max = i - mid + 1;
						res[0] = mid;
						res[1] = i;
					}
				}
			}
		}
		return res;
	}
	
	public static void main (String args[]){
		CumulateMinMaxIndexDifference cm = new CumulateMinMaxIndexDifference();
		int [] res = cm.returnMaxDif(new int [] {6,5,4,3,2,1});
		for (int r : res){
			System.out.println(r);
		}
	}
}
