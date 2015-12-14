package Zenefits;

public class WordSearchChange {
	public boolean dfs(int x, int y, String target, char[][] matrix, int index) {
		if (index == (int) target.length()) {
			return true;
		}
		int dx[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int dy[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int i = 0; i < 8; i++) {
			int next_x = x + dx[i], next_y = y + dy[i];
			if (next_x < 0 || next_x >= (int) matrix.length)
				continue;
			if (next_y < 0 || next_y >= (int) matrix[0].length)
				continue;
			if (target.charAt(index) == matrix[next_x][next_y]) {
				matrix[next_x][next_y] = '#';
				if (dfs(next_x, next_y, target, matrix, index + 1)) {
					matrix[next_x][next_y] = target.charAt(index);
					return true;
				}
				matrix[next_x][next_y] = target.charAt(index);
			}
		}
		return false;
	}

	boolean findWord(char[][] matrix, String target) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == target.charAt(0)) {
					matrix[i][j] = '#';
					if (dfs(i, j, target, matrix, 1)) {
						matrix[i][j] = target.charAt(0);
						return true;
					}
					matrix[i][j] = target.charAt(0);
				}
			}
		}
		return false;
	}

	public static void main(String args[]) {
		WordSearchChange ws = new WordSearchChange();
		System.out.println(ws.findWord(new char [][]   {{'N','O','P','K'},
														{'D','G','S','T'},
														{'C','A','O','P'}}, "DOGS"));
	}
}
