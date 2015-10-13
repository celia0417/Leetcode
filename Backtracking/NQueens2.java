package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {
	int res =0;
	public int solveNQueens(int n) {
		List<Integer> col = new ArrayList<Integer>();
		helper(n, 0, col);
		return res;
	}

	public void helper(int n, int irow, List<Integer> col) {
		if (irow == n) {
			res ++;
		}
		for (int icol = 0; icol < n; icol++) {
			if (isValid(col, irow, icol)) {
				col.add(icol);
				helper(n, irow + 1, col);
				col.remove(col.size() - 1);
			}
		}
	}

	public boolean isValid(List<Integer> col, int irow, int icol) {
		if (irow < col.size())
			return false;
		for (int i = 0; i < col.size(); i++) {
			if (col.get(i) == icol || Math.abs(i - irow) == Math.abs(col.get(i) - icol)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){ 
		NQueens2 nq = new NQueens2();
		int res = nq.solveNQueens(8);
		System.out.println(res);
	}
}
