package Google;

import java.util.*;

public class FindVerticalLine {
	private static final Comparator<Interval> comparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.x - o2.x;
		}
	};

	public boolean findVertical(Interval[] intervals) {
		Arrays.sort(intervals, comparator);
		int n = intervals.length;
		int median;
		if (n % 2 == 0)
			median = (intervals[intervals.length / 2].x + intervals[intervals.length / 2 + 1].x) / 2;
		else
			median = intervals[intervals.length / 2].x;
		for (int i = 0; i < intervals.length; i++) {
			if (Math.abs(intervals[i].x - median) != Math.abs(intervals[n - 1 - i].x - median)
					|| intervals[i].y != intervals[n - 1 - i].y) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		FindVerticalLine fv = new FindVerticalLine();
		Interval i1 = new Interval(1, 1);
		Interval i2 = new Interval(2, 1);
		Interval i3 = new Interval(8, 1);
		Interval i4 = new Interval(14, 1);
		Interval i5 = new Interval(15, 1);
		Interval[] intervals = { i1, i2, i3, i4, i5 };
		System.out.println(fv.findVertical(intervals));
	}
}
