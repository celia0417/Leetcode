package Math;

public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		dfs(board);
	}

	public boolean dfs(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (int x = 0; x < 9; x++) {
						board[i][j] = (char) (x + '1');
						if (check(board, i, j) && dfs(board)) {
							return true;
						}
						board[i][j] = '.';
					}
					return false;
				}
			}
		}
		return true;
	}

	public boolean check(char[][] board, int i, int j) {
		for (int p = 0; p < 9; p++) {
			if (p != j && board[i][p] == board[i][j])
				return false;
		}

		for (int q = 0; q < 9; q++) {
			if (q != i && board[q][j] == board[i][j])
				return false;
		}

		for (int l = i / 3 * 3; l < i / 3 * 3 + 3; l++) {
			for (int k = j / 3 * 3; k < j / 3 * 3 + 3; k++) {
				if (i != l && j != k && board[l][k] == board[i][j])
					return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		SudokuSolver ss = new SudokuSolver();

		ss.solveSudoku(new char[][] { { '.', '.', '9', '7', '4', '8', '.', '.', '.' },
				{ '7', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '2', '.', '1', '.', '9', '.', '.', '.' },
				{ '.', '.', '7', '.', '.', '.', '2', '4', '.' }, { '.', '6', '4', '.', '1', '.', '5', '9', '.' },
				{ '.', '9', '8', '.', '.', '.', '3', '.', '.' }, { '.', '.', '.', '8', '.', '3', '.', '2', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '6' }, { '.', '.', '.', '2', '7', '5', '9', '.', '.' } });
	}
}
