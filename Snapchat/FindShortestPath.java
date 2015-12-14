package Snapchat;

import java.util.*;

public class FindShortestPath {
	public int findPath(boolean[][] block) {

		// true as block, false as no block\
		if (block == null || block.length == 0 || block[0][0] == true)
			return 0;
		int[][] matrix = new int[block.length][block[0].length];
		boolean[][] visit = new boolean[block.length][block[0].length];
		int[] x = {1, -1, 0, 0};
		int[] y = {0, 0, 1, -1};
		Queue<String> queue = new LinkedList<String>();
		queue.offer("0,0");
		int level = 0;
		while (!queue.isEmpty()) {
			Queue<String> tempQueue = new LinkedList<String>();
			while (!queue.isEmpty()) {
				String cur = queue.poll();
				int row = Integer.parseInt(cur.split(",")[0]);
				int col = Integer.parseInt(cur.split(",")[1]);
				matrix[row][col] = level;
				visit[row][col] = true;
				System.out.println(row + "," + col + "," + level);
				for (int i = 0; i < x.length; i++) {
					int curRow = row + x[i];
					int curCol = row + y[i];
	
					if (curRow < 0 || curRow >= block.length || curCol < 0 || curCol >= block[0].length || block[curRow][curCol] || visit[curRow][curCol]) {
						continue;
					}
					System.out.println("1:" + curRow + "," + curCol);
					tempQueue.offer(curRow + "," + curCol);
				}
			}
			queue = tempQueue;
			level++;
		}
		return matrix[block.length - 1][block[0].length - 1];
	}
	public static void main(String[] args) {
		boolean[][] block = new boolean[4][6];
		block[0][2] = true;
		block[1][2] = true;
		block[2][2] = true;
		System.out.println(new FindShortestPath().findPath(block));
		
	}
}
