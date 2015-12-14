package Google;


import java.util.*;

public class StreamLongestSubstring {
	List<Character> list = new ArrayList<>();
	int start = 0;
	Map<Character, Integer> record = new HashMap<>();
	int cnt = 0;
	int max = 0;
	public int read(String str, int M){
		for (char c : str.toCharArray()){
			if (!record.containsKey(c)){
				list.add(c);
				cnt ++;
				
			}else {
				list.add(c);
				record.put(c, record.get(c) + 1);
			}
			while (cnt >= M){
				if (cnt == M) max = Math.max(max,list.size() - start);
				char s = list.get(start++);
				record.put(s, record.get(s) - 1);
				if (record.get(s) == 0){
					cnt --;
				}
			}
		}
		return max;
	}
	
	// speed up, object (val, pos) -> comparator pop up the smallest pos
}
