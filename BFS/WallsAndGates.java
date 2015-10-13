package BFS;

import java.util.*;

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
		int m = rooms.length;
	    if (m == 0) return;
	    int n = rooms[0].length;
	    for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rooms[i][j] == 0) {
					bfs(rooms, i, j, rooms[0].length);
				}
			}
		}
	}

	public void bfs(int[][] rooms, int i, int j, int n) {
		Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> dep = new LinkedList<>();
		dep.offer(0);
		q.offer(i * n + j);
		while (!q.isEmpty()) {
			int pos = q.poll();
			int depth = dep.poll();
			int x = pos / n;
			int y = pos % n;
			visited.add(x * n + y);
			if (rooms[x][y] != 0)
				rooms[x][y] = Math.min(rooms[x][y], depth);
			check(x - 1, y, visited, n, rooms, q, dep, depth);
			check(x + 1, y, visited, n, rooms, q, dep, depth);
			check(x, y - 1, visited, n, rooms, q, dep, depth);
			check(x, y + 1, visited, n, rooms, q, dep, depth);
		}
	}

	public void check(int i, int j, Set<Integer> visited, int n, int[][] rooms, Queue<Integer> q, Queue<Integer> dep,
			int depth) {
		if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == 0 || rooms[i][j] == -1
				|| visited.contains(i * n + j))
			return;
		q.offer(i * n + j);
		dep.offer(depth + 1);

	}

	public static void main(String args[]) {
		WallsAndGates wg = new WallsAndGates();
//		int[][] rooms = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
//				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
//				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };
		
		int [][] rooms = {{2147483647,0,2147483647,2147483647,0,2147483647,-1,2147483647}};
		wg.wallsAndGates(rooms);
		for (int[] r : rooms) {
			for (int i : r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
