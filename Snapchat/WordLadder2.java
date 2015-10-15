package Snapchat;

import java.util.*;

public class WordLadder2 {
	int minDepth = Integer.MAX_VALUE;
	List<List<String>> res = new ArrayList<List<String>>();

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		Map<String, Integer> map = new HashMap<>();
		Map<Integer, List<String>> map2 = new HashMap<>();
		Queue<String> word = new LinkedList<>();
		word.add(beginWord);
		map.put(beginWord, 1);
		map2.put(1, new ArrayList<String>(Arrays.asList(beginWord)));

		while (!word.isEmpty()) {
			String cur = word.poll();
			int dep = map.get(cur);
			if (dep >= minDepth)
				continue;
			if (cur.equals(endWord)) {
				String pre = map2.get(1).get(0);
				System.out.print(pre + " ");
				for (int i = 2; i < dep; i++) {
					List<String> list = map2.get(i);
					for (String s : list) {
						for (int j = 0; j < s.length(); j++) {
							char newChar[] = s.toCharArray();
							for (char c = 'a'; c <= 'z'; c++) {
								newChar[j] = c;
								String newString = new String(newChar);
								if (newString.equals(pre)) {
									pre = newString;
									System.out.println(pre + " ");
									break;
								}
							}
						}
					}
				}
				minDepth = Math.min(minDepth, dep);
				break;
			}

			for (int i = 0; i < cur.length(); i++) {
				char[] newChar = cur.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					newChar[i] = c;
					String newString = new String(newChar);
					if (wordList.contains(newString) && !map.containsKey(newString)) {
						word.add(newString);
						map.put(newString, dep + 1);
						if (map2.containsKey(dep + 1))
							map2.get(dep + 1).add(newString);
						else
							map2.put(dep + 1, new ArrayList<String>(Arrays.asList(newString)));
					}
				}
			}
		}
		List<String> list = new ArrayList<>();
		list.add(beginWord);
		dfs(map, beginWord, endWord, list);
		return res;
	}

	public void dfs(Map<String, Integer> map, String startWord, String endWord, List<String> list) {
		if (startWord.equals(endWord)) {
			List<String> sol = new ArrayList<String>();
			for (String str : list) {
				sol.add(str);
			}
			res.add(sol);
			return;
		}
		int dep = map.get(startWord);
		for (int i = 0; i < startWord.length(); i++) {
			char newChar[] = startWord.toCharArray();
			for (char c = 'a'; c <= 'z'; c++) {
				newChar[i] = c;
				String newString = new String(newChar);
				if (map.containsKey(newString) && map.get(newString) == dep + 1) {
					list.add(newString);
					dfs(map, newString, endWord, list);
					list.remove(list.size() - 1);
				}
			}
		}
	}

	public static void main(String args[]) {
		WordLadder2 wl = new WordLadder2();
		Set<String> set = new HashSet<String>();
		set.add("hit");
		set.add("cog");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		set.add("hot");
		List<List<String>> res = wl.findLadders("hit", "cog", set);
		for (List<String> l : res) {
			for (String s : l) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
}
