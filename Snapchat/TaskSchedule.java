package Snapchat;

import java.util.*;

public class TaskSchedule {
	public int coolDown(String str, int k) {
		int res = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int temp = 0;
			if (map.containsKey(c)) {
				if (res + 1 - map.get(c) <= k) {
					temp = k - (res - map.get(c));
				}
			}
			res += temp + 1;
			map.put(c, res);
		}
		return res;
	}
	
	public String bestSchedule(String str, int k){
		
		return "";
	}
}
