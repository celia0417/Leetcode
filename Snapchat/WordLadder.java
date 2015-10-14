package Snapchat;

import java.util.*;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> set = new HashSet<String>(); // check visited
        Queue<String> word = new LinkedList<>();
        Queue<Integer> depth = new LinkedList<>();
        word.add(beginWord);
        depth.add(1);
        
        while (!word.isEmpty()){
            String cur = word.poll();
            int dep = depth.poll();
            if (cur.equals(endWord)) return dep;
            
            for (int i =0; i < cur.length(); i++){
            	char [] newChar = cur.toCharArray();
                for (char c = 'a'; c < 'z'; c++){
                	newChar [i] = c;
                    String newString = new String(newChar);
                    if (wordList.contains(newString) && !set.contains(newString)){
                        word.add(newString);
                        depth.add(dep +1);
                        set.add(newString);
                    }
                }
            }
        }
        return 0;
    }
}
