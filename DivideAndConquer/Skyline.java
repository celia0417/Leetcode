package DivideAndConquer;

import java.util.*;

public class Skyline {
	private static final Comparator<int[]> comparator = new Comparator<int[]>() {
		@Override
		public int compare(int x[], int y[]) {
			if (x[0] - y[0] > 0)
				return 1;
			else if (x[0] - y[0] < 0)
				return -1;
			else
				return x[1] - y[1];
		}
	};

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> res = new ArrayList<int[]>();
		int cur = 0, curX, curH, len = buildings.length;
		Queue<int[]> liveBlg = new PriorityQueue<int[]>(buildings.length, comparator);
		
		while (cur < len || !liveBlg.isEmpty()) {
			if (liveBlg.isEmpty() || cur<len && buildings[cur][0] <= liveBlg.peek()[1]) {
				curX = buildings[cur][0];
				while (cur < len && buildings[cur][0] == curX) {
					int temp[] = { buildings[cur][2], buildings[cur][1] };
					liveBlg.offer(temp);
					cur++;
				}
			} else {
				curX = liveBlg.peek()[1];
				while (liveBlg.size() != 0 && liveBlg.peek()[1] <= curX) {
					liveBlg.poll();
				}
			}
			curH = liveBlg.isEmpty() ? 0 : liveBlg.peek()[0];
			if (res.isEmpty() || res.get(res.size() - 1)[1] != curH) {
				int temp[] = { curX, curH };
				res.add(temp);
			}
		}
		return res;
	}

	public static void main(String args[]) {
		Skyline sl = new Skyline();
		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<int[]> res = sl.getSkyline(buildings);
		for (int[] array : res) {
			for (int i : array) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
