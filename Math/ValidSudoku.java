package Math;

import java.util.*;

public class ValidSudoku {
	public static boolean isValidSudoku(char[][] board) {
		boolean[] visited = new boolean[9];
		int m = board.length, n = board[0].length;
		// check rows
		for (int i = 0; i < m; i++) {
			Arrays.fill(visited, false);
			for (int j = 0; j < n; j++) {
				if (!check(visited, board, i, j))
					return false;
			}
		}
		// check column
		for (int j = 0; j < n; j++) {
			Arrays.fill(visited, false);
			for (int i = 0; i < m; i++) {
				if (!check(visited, board, i, j))
					return false;
			}
		}

		// check sub-box
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Arrays.fill(visited, false);
				for (int k = 0; k < 9; k++) {
					if (!check(visited, board, i * 3 + k / 3, j * 3 + k % 3))
						return false;
				}
			}
		}
		return true;
	}

	public static boolean check(boolean[] visited, char[][] board, int i, int j) {
		if (visited[board[i][j] - '1'])
			return false;
		else
			visited[board[i][j] - '1'] = true;
		return true;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String sudoku = scanner.nextLine();
		int totalLen = sudoku.length();
		int len = (int) Math.sqrt(totalLen);
		char board[][] = new char[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				board[i][j] = sudoku.charAt(i * len + j);
			}
		}

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		ValidSudoku vs = new ValidSudoku();

		System.out.println(ValidSudoku.isValidSudoku(board));
	}
}
