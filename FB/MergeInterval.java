package FB;

import java.util.*;

public class MergeInterval {
	public List<Interval> merge(List<Interval> intervals) {
        // List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        
        Interval pre = intervals.get(0);
        int start = pre.start;
        int end = pre.end;
        for (Interval interval : intervals){
            if (interval.start <= end && interval != pre){
                end = Math.max(interval.end, end);
                intervals.remove(pre);
                pre = interval;
            }else{
                pre.start = start;
                pre.end = end;
                start = interval.start;
                end = interval.end;
            }
        }
        // res.add(new Interval(start, end));
        return intervals;
    }
	
	public static void main (String args[]){
		
	}
}
