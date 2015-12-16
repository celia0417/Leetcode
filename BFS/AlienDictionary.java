package BFS;

import java.util.*;

public class AlienDictionary {
	public String alienOrder(String[] words) {
		int matrix[][] = new int[26][26];
		List<Integer> order = new ArrayList<Integer>();
		int indegree[] = new int[26];
		Set<Integer> set = new HashSet<Integer>();
		for (String word : words) {
			char c = word.charAt(0);
			set.add(c - 'a');
			order.add(c - 'a');
			for (int i = 1; i < word.length(); i++) {
				set.add(word.charAt(i) - 'a');
				if (matrix[c - 'a'][word.charAt(i) - 'a'] == 0) {
					indegree[word.charAt(i) - 'a']++;
				}
				matrix[c - 'a'][word.charAt(i) - 'a'] = 1;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (set.contains(i) && indegree[i] == 0)
				queue.offer(i);
		}
		String res = "";
		while (!queue.isEmpty()) {
			int c = queue.poll();
			res += (char) (c + 'a');
			for (int i = 0; i < 26; i++) {
				if (matrix[c][i] == 1) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return res;
	}

	public String alienOrder2(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				if (!graph.containsKey(words[i].charAt(j))) {
					graph.put(words[i].charAt(j), new HashSet<Character>());
				}
			}
			if (i > 0) {
				getOrder(words[i - 1], words[i], graph);
			}
		}
		return topSort(graph);
	}

	private String topSort(Map<Character, Set<Character>> graph) {
		StringBuilder sb = new StringBuilder();
		Map<Character, Integer> indegree = new HashMap<>();
		for (char c : graph.keySet()) {
			for (char x : graph.get(c)) {
				if (!indegree.containsKey(x)) {
					indegree.put(x, 1);
				}else indegree.put(x, indegree.get(x)  + 1);
			}
		}
		
		Queue<Character> queue = new LinkedList<>();
		for (char c : graph.keySet()){
			if (!indegree.containsKey(c)) queue.offer(c);
		}
		
		while (!queue.isEmpty()){
			char cur = queue.poll();
			sb.append(cur);
			for (char c : graph.get(cur)){
				indegree.put(c, indegree.get(c) -1);
				if (indegree.get(c) == 0){
					queue.offer(c);
				}
			}
		}
		
		for (char key : indegree.keySet()) if (indegree.get(key) != 0) return "";
		
		return sb.toString();
	}

	private void getOrder(String s, String t, Map<Character, Set<Character>> graph) {
		for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
			char c1 = s.charAt(i), c2 = t.charAt(i);
			if (c1 != c2) {
				if (!graph.get(c1).contains(c2)) {
					graph.get(c1).add(c2);
				}
				break;
			}
		}
	}

	public static void main(String args[]) {
		AlienDictionary ad = new AlienDictionary();
		String words[] = { "wrt", "wrf", "er", "ett", "rftt" };
		System.out.println(ad.alienOrder2(words));
	}
}
