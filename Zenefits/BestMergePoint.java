package Zenefits;

import java.util.*;

public class BestMergePoint {
	/*
	 * //problem: robot merge point //input: //robot: 1 //obstacle: X [.
	 * 1point3acres.com/bbs 0 0 0 M 1 0 1 X 0 0 0 X 0 0 0 0 0 0 1 0 0 0 0 0 0 ]
	 * //output: //best merge point: M 3 + 1 + 3 = 7
	 * 
	 * Definition: Best merge point: minimal sum of path num between robots and
	 * merge point
	 */
	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	Point bestMergePoint(char[][] mat) {
		int m = mat.length;
		if (m == 0)
			return null;
		int n = mat[0].length;

		// bfs each point that is 1
		int[][] dis = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (mat[i][j] == '1')
					bfs(mat, i, j, dis);
			}
		}
		// count number
		int min = Integer.MAX_VALUE;
		Point ret = null;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// if this point is not visited by a robot. more info on
				// 1point3acres.com
				if (dis[i][j] == 0 && mat[i][j] == '0')
					continue;
				if (mat[i][j] != 'X' && dis[i][j] < min) {
					min = dis[i][j];
					ret = new Point(i, j);
				}
			}
		}
		return ret;
	}

	// bfs matrix to mark the distance from x and y
	void bfs(char[][] mat, int x, int y, int[][] dis) {
		Queue<Point> path = new LinkedList();
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		int m = mat.length;
		int n = mat[0].length;
		boolean[][] visited = new boolean[m][n];
		int ct = 0;
		System.out.println("Started at: " + x + " " + y);
		int di = 0;
		path.offer(new Point(x, y));
		visited[x][y] = true;
		while (!path.isEmpty()) {
			int count = path.size();
			for (int i = 0; i < count; i++) {
				Point cur = path.poll();
				ct++;
				// System.out.println(cur.x + " " + cur.y);
				// visited[cur.x][cur.y] = true;
				// update cur.value
				dis[cur.x][cur.y] += di;
				// check its neighbors
				for (int j = 0; j < 4; j++) {
					int nx = cur.x + dx[j];
					int ny = cur.y + dy[j];
					if (nx >= 0 && nx < m && ny >= 0 && ny < m && mat[nx][ny] != 'X' && !visited[nx][ny]) {
						path.offer(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
			}
			di++;
		}
		System.out.println("total points added to queue: " + ct);
	}

	public static void main(String[] args) {
		BestMergePoint sln = new BestMergePoint();
		char[][] mat = { { '0', '0', '0', '0', '1' },
					{ '0', '1', 'X', '0', '0' }, { '0', 'X', '0', '0', '0' },
				{ '0', '0', '0', '1', '0' }, { '0', '0', '0', '0', '0' } };
		Point ret = sln.bestMergePoint(mat);
		System.out.println(ret.x + " " + ret.y);
	}
}
