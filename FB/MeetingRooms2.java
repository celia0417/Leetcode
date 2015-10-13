package FB;

import java.util.*;

public class MeetingRooms2 {
	private static final Comparator<Interval> comparator = new Comparator<Interval> (){
        @Override
        public int compare(Interval x, Interval y) {
            return x.end - y.end;
        }  
    };
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals.length == 0)
			return 0;

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		Queue<Interval> heap = new PriorityQueue<>(intervals.length, comparator);

		heap.offer(intervals[0]);

		for (int i = 1; i < intervals.length; i++) {
			Interval earlyEnd = heap.poll();
			if (intervals[i].start < earlyEnd.end) {
				heap.offer(intervals[i]);
			}else{
				earlyEnd.end = intervals[i].end;
			}
			heap.offer(earlyEnd);
		}
		return heap.size();
    }
}
