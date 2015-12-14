package Google;

import java.util.*;

public class WordPattern2 {
	private boolean res = false;
    public boolean wordPatternMatch(String pattern, String str) {
        helper (pattern, str, 0, 0, new HashMap<Character, String>());
        return res;
    }
    
    public void helper (String pattern, String str, int i, int j, Map<Character, String> map){
        if (i == pattern.length() && j == str.length()) {
            res = true;
            return;
        }
        for (int y = j + 1; y < str.length(); y++){
            String substring = str.substring(j, y);
            if (map.containsKey(pattern.charAt(i))){
                if (map.get(pattern.charAt(i)).equals(substring)){
                    helper(pattern, str, i + 1, y, map);
                }
            }else {
                map.put(pattern.charAt(i), substring);
                helper(pattern, str, i + 1, y, map);
                map.remove(pattern.charAt(i));
            }
        }
    }
    
    public static void main (String args[]){
    	WordPattern2 wp = new WordPattern2();
    	System.out.println(wp.wordPatternMatch("abab", "redblueredblue"));
    }
}
