package Google;

import java.util.*;

public class LongestAscendingPath {
	public static List<Integer> longestAscendingPath(int[][] matrix, int tx, int ty) {
		List<List<Integer>> resList = new ArrayList<>();
		List<Integer> result = new ArrayList<Integer>();
		resList.add(result);
		helper(resList, matrix, new boolean[matrix.length][matrix[0].length], tx, ty, 0, 0, new ArrayList<Integer>());
		return resList.get(0);
	}

	static void helper(List<List<Integer>> result, int[][] matrix, boolean[][] visited, int tx, int ty, int x, int y,
			List<Integer> cur) {
		if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
			return;
		}
		if (visited[x][y]) {
			return;
		}
		if (!cur.isEmpty() && matrix[x][y] <= cur.get(cur.size() - 1)) {
			return;
		}
		visited[x][y] = true;
		cur.add(matrix[x][y]);

		if (tx == x && ty == y) {
			if (cur.size() > result.get(0).size()) {
				result.set(0, new ArrayList<Integer>(cur));
			}
//			cur.remove(cur.size() - 1); // !!!!!!!!Need to restore the state
//										// before every return
//			visited[x][y] = false;
			return;
		}

		helper(result, matrix, visited, tx, ty, x - 1, y, cur);
		helper(result, matrix, visited, tx, ty, x + 1, y, cur);
		helper(result, matrix, visited, tx, ty, x, y - 1, cur);
		helper(result, matrix, visited, tx, ty, x, y + 1, cur);
		cur.remove(cur.size() - 1);
		visited[x][y] = false;
	}

	public static void main(String args[]) {
		LongestAscendingPath lap = new LongestAscendingPath();
		int matrix[][] = { { 2, 3, 1 }, { 9, 4, 5 }, { 7, 8, 6 } };
		List<Integer> res = lap.longestAscendingPath(matrix, 2, 1);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
