package BitManipulation;

import java.util.*;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> res = new ArrayList<String>();
        Map<Integer, Integer> visited = new HashMap<>();
        char [] map = new char [26];
        map ['A' - 'A'] = 0;
        map ['C' - 'A'] = 1;
        map ['G' - 'A'] = 2;
        map ['T' - 'A'] = 3;
        int str = 0, len = 10;
        for (int i = 10; i < s.length(); i++){
            str = str << 2;
            str |= map[s.charAt(i) - 'A'];
            if (i == len -1) visited.put(str, 1);
            else if (len > len -1){
                str |= (3 << 20);
                if (visited.containsKey(str)) 
                    visited.put(str, visited.get(str)+1);
                else
                    visited.put(str, 1);
                if (visited.get(str) == 2)
                    res.add(Integer.toString(str));
            }
        }
        return res;
    }
}
