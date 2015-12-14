	package Snapchat;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && !visited[i][j])
					if (findWord(board, visited, word, i, j, 0))
						return true;
			}
		}
		return false;
	}

	public boolean findWord(char[][] board, boolean[][] visited, String word, int i, int j, int count) {
		if (count == word.length())
			return true;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]
				|| board[i][j] != word.charAt(count))
			return false;
		visited[i][j] = true;
		int dx[] = {-1,-1,-1,0,0,1,1,1};
		  int dy[] = {-1,0,1,-1,1,-1,0,1};
		  for (int k = 0; k < 8; i++) {
			    int next_x = i + dx[k], next_y = j + dy[k];

		if (findWord(board, visited, word, 	i - 1, j, count + 1))
			return true;
		if (findWord(board, visited, word, i + 1, j, count + 1))
			return true;
		if (findWord(board, visited, word, i, j - 1, count + 1))
			return true;
		if (findWord(board, visited, word, i, j + 1, count + 1))
			return true;
		visited[i][j] = false;
		  }
		return false;
	}
}
