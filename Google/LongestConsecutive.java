package Google;

import java.util.*;

public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> res = new HashMap<Integer, Integer>();
		int max = 0, start = -1;
		for (int num : nums) {
			if (!map.containsKey(num))
				map.put(num, 1);
			else
				map.put(num, map.get(num) + 1);
		}
		for (int num : nums) {
			Map<Integer, Integer> output = new HashMap<Integer, Integer>();
			int len = 1;
			int tempStart = num;
			output.put(num, map.get(num));
			for (int j = num + 1; map.containsKey(j); j++) {
				output.put(j, map.get(j));
				len += map.get(j);
				map.remove(j);
			}

			for (int j = num - 1; map.containsKey(j); j--) {
				tempStart = j;
				output.put(j, map.get(j));
				len += map.get(j);
				map.remove(j);
			}
			map.remove(num);
			if (len > max) {
				max = len;
				start = tempStart;
				res = output;
			}
		}
		for (int i = start; i < start + res.size(); i++) {
			int cnt = res.get(i);
			
			while (cnt > 0) {
				System.out.print(i + " ");
				cnt--;
			}
		}

		return max;
	}

	public static void main(String args[]) {
		LongestConsecutive lc = new LongestConsecutive();
		System.out.println(lc.longestConsecutive(new int[] { 100, 4, 200, 1, 3, 2, 2, 2, 2 }));
	}
}
