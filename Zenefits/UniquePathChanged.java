package Zenefits;

import java.util.*;

public class UniquePathChanged {
	private int cnt;
	private Set<Integer> visited = new HashSet<>();
	public int unique(int[][] board) {
		if (board == null) {
			return 0;
		}
		helper(board, 0, 0, 0);

		return cnt;
	}

	private void helper(int[][] board, int i, int j, int val) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] <= val || visited.contains(i * board[0].length + board.length)) {
			return;
		}
		if (board[i][j] == 1) {
			cnt++;
			return;
		}
		visited.add(i * board[0].length + board.length);
		helper(board, i + 1, j, board[i][j]);
		helper(board, i - 1, j, board[i][j]);
		helper(board, i, j + 1, board[i][j]);
		helper(board, i, j - 1, board[i][j]);
		visited.remove(i * board[0].length + board.length);
	}

}
