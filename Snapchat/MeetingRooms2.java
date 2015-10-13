package Snapchat;

import java.util.*;

public class MeetingRooms2 {
	private static final Comparator<Interval> comparator = new Comparator<Interval>() {
		@Override
		public int compare(Interval x, Interval y) {
			return x.end - y.end;
		}
	};

	public List<List<Interval>> minMeetingRooms(Interval[] intervals) {
		List<List<Interval>> res = new ArrayList<List<Interval>>();
		if (intervals.length == 0)
			return res;

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, comparator);

		heap.offer(intervals[0]);
		List<Interval> list = new ArrayList<>();
		list.add(intervals[0]);
		for (int i = 1; i < intervals.length; i++) {
			Interval earlyEnd = heap.poll();
			if (intervals[i].start < earlyEnd.end) {
				res.add(list);
				list = new ArrayList<Interval>(Arrays.asList(intervals[i]));
				heap.offer(intervals[i]);
			} else {
				list.add(intervals[i]);
				earlyEnd.end = intervals[i].end;
			}
			heap.offer(earlyEnd);
		}
		res.add(list);
		return res;
	}
		
	public static void main(String args[]) {
		MeetingRooms2 mr = new MeetingRooms2();
		Interval i1 = new Interval(0, 30);
		Interval i2 = new Interval(5, 10);
		Interval i3 = new Interval(15, 20);
		List<List<Interval>> res = mr.minMeetingRooms(new Interval[] { i1, i2, i3 });
		for (List<Interval> l : res) {
			for (Interval i : l) {
				System.out.print(i.start + "->" + i.end+" ");
			}
			System.out.println();
		}
	}
}
