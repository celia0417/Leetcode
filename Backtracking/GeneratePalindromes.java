package Backtracking;

import java.util.*;

public class GeneratePalindromes {
	List<String> res = new ArrayList<>();
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        int cnt = 0;
        for (char key : map.keySet()){
            if (map.get(key) % 2 == 1){
                cnt ++;
            }
            if (cnt > 1) return res;
        }
        
        List<Character> list = new ArrayList<>();
        String mid = "";
        for (char key : map.keySet()){
            int val = map.get(key);
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val/2; i++) list.add(key);
        }        
        
        helper(list, new StringBuilder(), mid, list.size());
        return res;
    }
    
    public void helper(List<Character> list, StringBuilder sb, String mid, int n){
        if (sb.length() == n){
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++){
            char temp = list.remove(i);
            sb.append(temp);
            helper(list, sb, mid, n);
            sb.deleteCharAt(sb.length()-1);
            list.add(i,temp);
        }
    }
    
    public static void main(String args[]){
    	GeneratePalindromes gp = new GeneratePalindromes();
    	gp.generatePalindromes("aabbcc");
    }
}
