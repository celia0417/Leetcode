package Zenefits;

public class Skiing {
	// consecutive
//	public int exist(int[][] board) {
//		if (board == null) {
//			return 0;
//		}
//		int max = 0;
//		int cnt[][] = new int[board.length][board[0].length];
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[0].length; j++) {
//				int len = helper(board, i, j, board[i][j], cnt);
//				max = Math.max(max, len);
//			}
//		}
//		return max;
//	}
//
//	private int helper(int[][] board, int i, int j, int val, int cnt[][]) {
//		int max = 0;
//		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != val) {
//			return 0;
//		}
//		if (cnt[i][j] > 0)
//			return cnt[i][j];
//
//		int l1 = helper(board, i + 1, j, val + 1, cnt);
//		int l2 = helper(board, i - 1, j, val + 1, cnt);
//		int l3 = helper(board, i, j + 1, val + 1, cnt);
//		int l4 = helper(board, i, j - 1, val + 1, cnt);
//		max = Math.max(l1, l2);
//		max = Math.max(max, l3);
//		max = Math.max(max, l4);
//		return cnt[i][j] = max + 1;
//	}
	
	// not consecutive 
	public int exist(int[][] board) {
		if (board == null) {
			return 0;
		}
		int max = 0;
		int cnt[][] = new int[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int len = helper(board, i, j, 0, cnt);
				max = Math.max(max, len);
			}
		}
		return max;
	}

	private int helper(int[][] board, int i, int j, int val, int cnt[][]) {
		int max = 0;
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] <= val) {
			return 0;
		}
		if (cnt[i][j] > 0)
			return cnt[i][j];

		int l1 = helper(board, i + 1, j, board[i][j], cnt);
		int l2 = helper(board, i - 1, j, board[i][j], cnt);
		int l3 = helper(board, i, j + 1, board[i][j], cnt);
		int l4 = helper(board, i, j - 1, board[i][j], cnt);
		max = Math.max(l1, l2);
		max = Math.max(max, l3);
		max = Math.max(max, l4);
		return cnt[i][j] = max + 1;
	}

	public static void main(String args[]) {
		Skiing sk = new Skiing();
		int matrix[][] = { { 7, 8, 9 }, { 4, 5, 9 }, { 3, 2, 1 } };
		System.out.println(sk.exist(matrix));
	}
}