package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	List<List<String>> res = new ArrayList<List<String>>();

	public List<List<String>> solveNQueens(int n) {
		List<Integer> col = new ArrayList<Integer>();
		List<String> list = new ArrayList<String>();
		helper(n, list, 0, col);
		return res;
	}

	public void helper(int n, List<String> list, int irow, List<Integer> col) {
		if (irow == n) {
			List<String> sol = new ArrayList<String> ();
			
			for (String str : list){
				sol.add(str);
			}
			res.add(sol);
		}
		for (int icol = 0; icol < n; icol++) {
			if (isValid(col, irow, icol)) {
				String str = "";
				for (int i = 0; i < n; i++) {
					if (i == icol)
						str += "Q";
					else
						str += ".";
				}
				list.add(str);
				col.add(icol);
				helper(n, list, irow + 1, col);
				list.remove(list.size() - 1);
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
		NQueens nq = new NQueens();
		List<List<String>> res = nq.solveNQueens(4);
		for (List<String> list : res){
			System.out.print("[");
			for (String s : list){
				System.out.print(s);
				System.out.println("");
			}
			System.out.print("]");
			System.out.println();
		}
	}
}
