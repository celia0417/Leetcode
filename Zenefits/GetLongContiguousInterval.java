package Zenefits;

import java.util.*;

public class GetLongContiguousInterval {
	// Given a stream of intergers for example, 1, 100, 201023, 2, 3, 4.

	// Pair<Integer, Integer> getLongContiguousInterval(int next);
	// Longest (a, b) such that all i in [a, b] have been seen in the stream up
	// to next.

	// two hashmap key (start) -> Pair; key (end) ->
	class Pair {
		int start;
		int end;

		public Pair(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}

	private int maxStart, maxLen;
	private Map<Integer, Pair> start = new HashMap<>();
	private Map<Integer, Pair> end = new HashMap<>();

	Pair getLongContiguousInterval(int next) {
		if (start.isEmpty() || (!start.containsKey(next + 1) && !end.containsKey(next -1))) {
			if (start.isEmpty()) maxStart = next;
			Pair p = new Pair(next, next);
			start.put(next, p);
			end.put(next, p);
		}
		if (start.containsKey(next + 1)) {
			Pair p = new Pair(next, start.get(next + 1).end);
			start.put(next, p);
			end.put(start.get(next + 1).end, p);
			start.remove(next + 1);
			
			if (start.get(next).end - next + 1 > maxLen){
				maxLen = start.get(next).end - next + 1;
				maxStart = next;
			}
		}
		if (end.containsKey(next - 1)) {
			Pair p = new Pair(end.get(next - 1).start, next);
			end.put(next, p);
			start.put(end.get(next - 1).start, p);
			end.remove(next - 1);
			if (next - end.get(next).start + 1 > maxLen){
				maxLen = next - end.get(next).start + 1;
				maxStart = end.get(next).start;
			}
		}
		
		return start.get(maxStart);
	}

	public static void main(String args[]) {
		GetLongContiguousInterval gl = new GetLongContiguousInterval();
		gl.getLongContiguousInterval(2);
		gl.getLongContiguousInterval(100);
		gl.getLongContiguousInterval(201023);
		gl.getLongContiguousInterval(1);
		gl.getLongContiguousInterval(3);
		Pair p = gl.getLongContiguousInterval(4);
		System.out.println(p.start + " " + p.end);
	}
}
