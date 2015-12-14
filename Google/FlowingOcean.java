package Google;

import java.util.*;

public class FlowingOcean {
	private boolean A = false;
	private boolean B = false;

	public List<Integer> exist(int[][] board) {
		int record[][] = new int[board.length][board[0].length];
//		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board[0].length; j++) {
				A = false;
				B = false;
				dfs(board, i, j, Integer.MAX_VALUE, record);
				if (A && B) {
					List<Integer> list = new ArrayList<Integer>(Arrays.asList(i, j));
					return list;
				}
			}
		}
		return null;

	}

	public void dfs(int[][] board, int i, int j, int val, int[][] record) {
		if(A && B) return;
		if (i < 0 || j >= board[0].length) {
			A = true;
			return;
		}
		if (j < 0 || i >= board.length) {
			B = true;
			return;
		}
		if (board[i][j] >= val) return;

		if (record[i][j] != 0){
			return;
		}

		dfs(board, i + 1, j, board[i][j], record);
		dfs(board, i - 1, j, board[i][j], record);
		dfs(board, i, j + 1, board[i][j], record);
		dfs(board, i, j - 1, board[i][j], record);

		if (A && B) record[i][j] = 1;
		else record[i][j] = -1;
	}
	
	public static void main (String args[]){
		FlowingOcean fo = new FlowingOcean();
		List<Integer> res = fo.exist(new int[][] {  
								{1,1,1},
								{1,2,1},
								{1,1,1}
									});
		for (int i : res){
			System.out.println(i);
		}
	}
}
