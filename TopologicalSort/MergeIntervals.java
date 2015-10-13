package TopologicalSort;

import java.util.*;

public class MergeIntervals {
	private static final Comparator<Interval> comparator = new Comparator<Interval> (){
        @Override
        public int compare(Interval x, Interval y){
            return x.end - y.end;
        }
    };
        
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) return res;
        
        Collections.sort(intervals, new Comparator<Interval> (){
        	
        	@Override
            public int compare(Interval x, Interval y){
                return x.start - y.start;
            }
        });
        
        Queue<Interval> heap = new PriorityQueue<Interval> (intervals.size(), comparator);
        
        heap.offer(intervals.get(0));
        
        for (int i =0; i < intervals.size(); i ++){
            Interval inter = heap.poll();
            if (intervals.get(i).start < inter.end){
                heap.offer(intervals.get(i));
            }else{
                inter.end = intervals.get(i).end;
            }
            heap.offer(inter);
        }
        for (Interval i : heap){
            res.add(i);
        }
        return res;
    }
}
