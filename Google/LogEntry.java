package Google;

import java.util.*;

public class LogEntry {
	private String candidate;
	private int time;

	public LogEntry(String candidate, int time) {
		this.candidate = candidate;
		this.time = time;
	}

	public String findWinner(int time, LogEntry[] logs) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		int max = 0;
		String maxCan = null;
		for (LogEntry log : logs) {
			if (log.time <= time) {
				if (!map.containsKey(log.candidate)) {
					map.put(log.candidate, 1);
				} else {
					map.put(log.candidate, map.get(log.candidate) + 1);
				}
				if (map.get(log.candidate) > max) {
					max = map.get(log.candidate);
					maxCan = log.candidate;
				}
			}
		}
		return maxCan;
	}

	public String[] findKWinner(int time, LogEntry[] logs, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (LogEntry log : logs) {
			if (log.time <= time) {
				if (!map.containsKey(log.candidate)) {
					map.put(log.candidate, 1);
				} else {
					map.put(log.candidate, map.get(log.candidate) + 1);
				}
			}
		}

		Map<String, Integer> newMap = sortByValue(map);
		String res[] = new String[k];
		int cnt = 0;
		for (String str : newMap.keySet()) {
			if (cnt >= k)
				break;
			res[cnt++] = str;
		}
		return res;
	}

	public static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
	
	
	public String[] findKWinner2(int time, LogEntry[] logs, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (LogEntry log : logs) {
			if (log.time <= time) {
				if (!map.containsKey(log.candidate)) {
					map.put(log.candidate, 1);
				} else {
					map.put(log.candidate, map.get(log.candidate) + 1);
				}
			}
		}

		Map<String, Integer> newMap = sortByValue(map);
		String res[] = new String[k];
		int cnt = 0;
		for (String str : newMap.keySet()) {
			if (cnt >= k)
				break;
			res[cnt++] = str;
		}
		return res;
	}
	public class Winner{
		String name ;
		int votes;
		public Winner(String name, int votes){
			this.name = name;
			this.votes = votes;
		}
	}

	public static void main (String args[]){
		LogEntry l1 = new LogEntry("a", 1);
		LogEntry l2 = new LogEntry("c",2);
		LogEntry l3 = new LogEntry("c",3);
		LogEntry [] logs = {l1, l2, l3};
		
		String[] res = l1.findKWinner(3, logs,1);
		for (String s : res){
			System.out.println(s);	
		}
	}
}
