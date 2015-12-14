package Google;

import java.util.*;

public class MoreInterval {
	private static final Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer x, Integer y) {
			return Math.abs(x) == Math.abs(y) ? x > 0 ? 1 : -1 : Math.abs(x) - Math.abs(y);
		}
	};

	public String moreInterval(Interval[] intervals) {
		Integer nums[] = new Integer[intervals.length * 2];
		for (int i = 0; i < intervals.length; i++) {
			nums[2 * i] = intervals[i].start;
			nums[2 * i + 1] = -intervals[i].end;
		}
		Arrays.sort(nums, comparator);
		int cnt = 0, max = 0, res1 = -1, res2 = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= 0) {
				cnt++;
				if (cnt > max) {
					res1 = nums[i];
					max = cnt;
				}
			} else {
				if (cnt == max){
					res2= nums[i];
				}
				cnt--;
			}
		}
		return res1 + "->"+Math.abs(res2);
	}

	public static void main(String args[]) {
		MoreInterval mi = new MoreInterval();
		Interval intervals[] = new Interval[] { new Interval(1, 5), new Interval(2, 6), new Interval(3, 8),
				new Interval(9, 10), new Interval(4, 7) };
		Interval i1 = new Interval(2, 3);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(4, 5);
		Interval i4 = new Interval(1, 5);
		Interval i5 = new Interval(1, 2);

		System.out.println(mi.moreInterval(intervals));
	}
}
