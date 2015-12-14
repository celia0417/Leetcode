package Zenefits;

import java.util.*;

public class PalindromePartition {
    public List<String> partition(String s) {
    	int cnt = 0;
    	List<String> res = new ArrayList<>();
    	for (int i = 0; i < s.length(); i++) cnt ++;
    	for (int i = 1; i < s.length(); i++) {
    		//even
    		for (int l = i -1, r = i; l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r); l--, r++){
    			cnt ++;
    			String sol = s.substring(l, r + 1);
    			res.add(sol);
    		}
    		//odd
    		for (int l = i , r = i; l >= 0 && r< s.length() && s.charAt(l) == s.charAt(r); l--, r++){
    			String sol = s.substring(l, r + 1);
    			res.add(sol);
    			cnt ++;
    		}
    	}
    	return res;
    }
    
    public static void main (String args[]){
    	PalindromePartition pp = new PalindromePartition();
    	List<String> res = pp.partition("abba");
    	for (String s : res){
        	System.out.println(s);
    	}
    }
}
