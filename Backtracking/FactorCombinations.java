package Backtracking;

import java.util.*;

public class FactorCombinations {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> getFactors(int n) {
        List<Integer> list = new ArrayList<>();
        helper(list, n);
        return res;
    }
    
    public void helper(List<Integer> list, int n){
        if (n == 1){
            List<Integer> sol = new ArrayList<>();
            for (int i : list){
                sol.add(i);
            }
            res.add(sol);
            return;
        }
        for (int i = 2; i <= n; i++){
            if (n % i == 0){
                int temp = n;
                list.add(i);
                n /= i;
                helper(list, n);
                list.remove(list.size()-1);
                n = temp;   
            }
        }
    }
    
    public static void main(String args[]){
    	FactorCombinations fc = new FactorCombinations();
    	fc.getFactors(28);
    }
}
