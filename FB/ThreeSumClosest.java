package FB;

import java.util.*;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
		int res = 0, min = Integer.MAX_VALUE;
		Arrays.sort(num);
		for (int i = 0; i < num.length - 2; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			int lookfor = target-num[i];
			int left = i + 1;
			int right = num.length - 1;
			while (left < right) {
				int sum = num[i] + num[left] + num[right];
				if (sum == target) return sum;
				else if (Math.abs(sum-target) < min){
					min = Math.abs(sum-target);
					res = sum;
				}
				else if (num[left] + num[right] <= lookfor) {
					left++;
					while (left < right && num[left] == num[left-1])
						left++;
				}
				else {
					right--;
					while (left < right && num[right] == num[right+1])
						right--;
				}
			}
		}
		return res;
    }
}
