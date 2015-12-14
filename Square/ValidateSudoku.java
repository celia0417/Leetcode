package Square;

import java.util.*;

public class ValidateSudoku {
	public boolean isValidSudoku(char[][] board) {
		int n = board.length;
		boolean[] check = new boolean[10];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((j + 1) % 9 == 0)
					Arrays.fill(check, false);
				if (board[i][j] == '.')
					continue;
				if (check[board[i][j] - '0'])
					return false;
				check[board[i][j] - '0'] = true;
			}
		}

		for (int j = 0; j < 9; j++) {
			Arrays.fill(check, false);
			for (int i = 0; i < 9; i++) {
				if ((i + 1) % 9 == 0)
					Arrays.fill(check, false);
				if (board[i][j] == '.')
					continue;
				if (check[board[i][j] - '0'])
					return false;
				check[board[i][j] - '0'] = true;
			}
		}

		int onethird = n /3;
		for (int i = 0; i < onethird; i++) {
			for (int j = 0; j < onethird; j++) {
				Arrays.fill(check, false);
				for (int k = 0; k < 9; k++) {
					if (board[i * 3 + k / 3][j * 3 + k % 3] == '.')
						continue;
					if (check[board[i * 3 + k / 3][j * 3 + k % 3] - '0'])
						return false;
					check[board[i * 3 + k / 3][j * 3 + k % 3] - '0'] = true;
				}
			}
		}
		return true;
	}
}
