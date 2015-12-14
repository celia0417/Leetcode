package Snapchat;

import java.util.HashMap;
import java.util.Map;

public class Kidnapping {
	public boolean kidnap(String note, String newsPaper) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < newsPaper.length(); i++) {
			if (newsPaper.charAt(i) == ' ')
				continue;
			if (!map.containsKey(newsPaper.charAt(i))) {
				map.put(newsPaper.charAt(i), 1);
			} else {
				map.put(newsPaper.charAt(i), map.get(newsPaper.charAt(i)) + 1);
			}
		}
		for (int i = 0; i < note.length(); i++) {
			char c = note.charAt(i);
			if (c == ' ')
				continue;
			if (!map.containsKey(c)) {
				return false;
			} else {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0)
					map.remove(c);
			}
		}
		return true;
	}
	
	public static void main (String args[]){
		Kidnapping kid = new Kidnapping();
		System.out.println(kid.kidnap("xcvghhv  fghjkj", "37859fjthtkbukiomfdfghjytrewse5tgbnjkjhgfdxcvghhv  fghjkjhgfdcvb fghjj"));
	}
}

