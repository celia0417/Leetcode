package Backtracking;

import java.util.*;

public class WordPatternMatch {
    public boolean wordPatternMatch(String pattern, String str) {
        return dfs(pattern, str, new HashMap<Character, String>(), 0, 0, new HashSet<String>());
    }
    
    public boolean dfs(String pattern, String str, Map<Character, String> map, int i, int j, Set<String> set){
    	if (i == str.length() && j == pattern.length()) return true;
    	if (i == str.length() || j == pattern.length()) return false;
    	
    	char c = pattern.charAt(j);
    	
    	String s = null;
        if (map.containsKey(c)){
        	s = map.get(c);
        	if (!str.startsWith(s, i)){
            	return false;
        	}
        	dfs(pattern, str, map, i + str.length(), j + 1, set);
        }
        
        for (int k = i+1; k < str.length(); k++){
        	String temp = str.substring(i,k);
        	if (set.contains(temp)){
        		continue;
        	}
        	set.add(temp);
        	map.put(c, temp);
        	if (dfs(pattern, str, map, k + 1, j + 1, set)){
        		return true;
        	}
        	set.remove(temp);
        	map.remove(c);
        }
        
        return false;
    } 
}
