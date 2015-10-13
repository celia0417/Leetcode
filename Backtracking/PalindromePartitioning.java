package Backtracking;

import java.util.*;

public class PalindromePartitioning {
	List<List<String>> res = new ArrayList<List<String>>();

	public List<List<String>> partition(String s) {
		List<String> list = new ArrayList<String>();
		List<Character> charList = new ArrayList<Character>();
		for (Character c : s.toCharArray()) {
			charList.add(c);
		}
		helper(list, s, 0);
		return res;
	}

	public void helper(List<String> list, String str, int l){
		if (list.size() > 0 && l == str.length()){
			List<String> sol = new ArrayList<String>();
			for (String s : list){
				sol.add(s);
			}
			res.add(sol);
		}
		
		for (int i = l; i < str.length(); i++){
			if (isPalindrome(str.substring(l,i+1))){
				if (l== i){
					list.add(Character.toString(str.charAt(l)));
				}else{
					list.add(str.substring(l,i+1));
				}
				helper(list, str, i+1);
				list.remove(list.size()-1);
			}
		}
	}
	
	public boolean isPalindrome(String str){
		for (int i =0; i < str.length()/2; i++){
			if (str.charAt(i) != str.charAt(str.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> res = pp.partition("aab");
		for (List<String> list : res){
			for (String str : list){
				System.out.println(str);
			}
			System.out.println();
		}
	}
}
