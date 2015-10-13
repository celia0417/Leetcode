package Array;

import java.util.*;

public class SummaryRange {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
        if (nums.length ==0) return res;
        int start = nums[0], end = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == end + 1) {
				end = nums[i];
			} else {
				if (start == end) {
					res.add(Integer.toString(start));
				} else {
					res.add(Integer.toString(start) + "->" + Integer.toString(end));
				}
				start = nums[i];
				end = nums[i];
			}
		}
		if (start == end) {
			res.add(Integer.toString(start));
		} else {
			res.add(Integer.toString(start) + "->" + Integer.toString(end));
		}
		return res;	
	}

	public List<String> summaryRanges2(int[] nums) {
	    List<String> res = new ArrayList<String>();
	    if(nums == null || nums.length == 0)
	        return res;
	    int start = 0;
	    int end = 0;

	    while(end < nums.length){
	        StringBuilder sb = new StringBuilder();
	        while(end < nums.length - 1 && nums[end] == nums[end + 1] - 1){
	            end ++;
	        }
	        if(start == end){
	            sb.append(nums[start]);
	            res.add(sb.toString());
	        }else{
	            sb.append(nums[start]);
	            sb.append("->");
	            sb.append(nums[end]);
	            res.add(sb.toString());
	        }
	        end++;
	        start = end;
	    }

	    return res;
	}
	public static void main(String args[]) {
		SummaryRange sr = new SummaryRange();
		int nums[] = { 1, 2, 4, 5, 7 };
		List<String> res = sr.summaryRanges(nums);
		for (String s : res) {
			System.out.println(s);
		}
	}
}
