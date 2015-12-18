package Backtracking;

import java.util.*;

public class RestoreIpAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, res, new StringBuilder(), 0, 0);
        return res;
    }
    
    public void dfs(String s, List<String> res, StringBuilder sb, int start, int cnt){
    	if (cnt > 4) return;
        if (start == s.length() && cnt == 4) res.add(sb.toString());
        for (int i = start; i < s.length(); i++){
            String temp = s.substring(start, i + 1);
            int digit = Integer.parseInt(temp);
            if(digit > 255) return;
            if(digit >= 0 && digit <= 255){
                int len = sb.length();
                sb.append(digit);
                if (i != s.length() -1 ) sb.append(".");
                dfs(s, res, sb, i + 1, cnt +1);
                sb.delete(len, sb.length());
            }
        }
    }
    
    public static void main (String args[]){
    	RestoreIpAddress ri = new RestoreIpAddress();
    	List<String> res = ri.restoreIpAddresses("25525511135");
    	for (String s: res){
    		System.out.println(s);
    	}
//    	System.out.println(res.get(0));
    }
}
