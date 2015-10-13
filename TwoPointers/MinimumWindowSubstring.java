package TwoPointers;

import java.util.*;

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int[] record = new int[256];
		Arrays.fill(record, Integer.MIN_VALUE);
		for (int i = 0; i < t.length(); i++) {
		    if (record[t.charAt(i)] == Integer.MIN_VALUE){
		       	record[t.charAt(i)] = 1;
		    }else if (record[t.charAt(i)] != Integer.MIN_VALUE){
		        record[t.charAt(i)]++;
		    }
		}
		int cnt = 0, start = 0, minLength = Integer.MAX_VALUE, minStart = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if(record[c] != Integer.MIN_VALUE){
				record[c]--;
				if (record[c] > 0) {
					cnt ++;
				}
			}
			while (cnt == t.length()) {
				char startChar = s.charAt(start);
				if (record[startChar] != Integer.MIN_VALUE) {
					record[startChar]++;
					if (record[startChar] > 0){
						if (minLength > i - start + 1){
							minLength = i - start + 1;
							minStart = start;
						}
						cnt--;
					}
				} 
				start++;
			}

		}
		if (minLength == Integer.MAX_VALUE)
			return "";
		return s.substring(minStart, minStart + minLength);
	}
}
