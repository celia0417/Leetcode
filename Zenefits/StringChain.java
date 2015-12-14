package Zenefits;

import java.util.*;

public class StringChain {

	// private int max = 0;
	//
	// public int stringChain(String words[]) {
	// Set<String> dict = new HashSet<>();
	// Map<String, Integer> depRec = new HashMap<>();
	// for (int i = 0; i < words.length; i++) {
	// dict.add(words[i]);
	// }
	//
	// for (int i = 0; i < words.length; i++) {
	// helper(words[i], dict, depRec);
	// }
	// return max;
	// }
	//
	// public void helper(String str, Set<String> dict, Map<String, Integer>
	// depRec) {
	// Queue<String> queue = new LinkedList<>();
	// Queue<Integer> depth = new LinkedList<>();
	// queue.add(str);
	// depth.add(1);
	// int updateDep = 1;
	// while (!queue.isEmpty()) {
	// String cur = queue.poll();
	// int dep = depth.poll();
	// for (int i = 0; i < cur.length(); i++) {
	// StringBuilder currStr = new StringBuilder(cur);
	// String newWord = currStr.deleteCharAt(i).toString();
	// if (depRec.containsKey(newWord)) {
	// updateDep = dep + depRec.get(newWord);
	// max = Math.max(dep + depRec.get(newWord), max);
	// } else if (dict.contains(newWord)) {
	// queue.add(newWord);
	// depth.add(dep + 1);
	// max = Math.max(max, dep + 1);
	// updateDep = dep + 1;
	// }
	// }
	// }
	// depRec.put(str, updateDep);
	// }

	static Comparator<String> comparator = new Comparator<String>(){
        @Override
        public int compare(String o1, String o2){
            return o2.length() - o1.length();
        }
    };
    static int max = 0;
    static int longest_chain(String[] w) {
        Set<String> dict = new HashSet<String>();
        Arrays.sort(w, comparator);
        for (int i = 0; i < w.length; i++){
            dict.add(w[i]);
        }
        
        for (int i =0; i < w.length; i++){
            if (w[i].length() <= max){
                break;
            }
            helper(w[i], dict);
        }
        return max;
    }

    static void helper(String str, Set<String> dict){
        Queue<String> queue = new LinkedList<String> ();
        Queue<Integer> depth = new LinkedList<Integer>();
        queue.add(str);
        depth.add(1);
        // bfs
        while(!queue.isEmpty()){
            String cur = queue.poll();
            int dep = depth.poll();
            max = Math.max(max, dep);
            for (int i = 0; i < cur.length(); i++){
                StringBuilder currStr = new StringBuilder(cur);
                String newWord = currStr.deleteCharAt(i).toString();
                if (dict.contains(newWord)){
                    dict.remove(newWord);
                    queue.add(newWord);
                    depth.add(dep + 1);
                }
            }
        }
    }

	public static void main(String args[]) {
		// StringChain sc = new StringChain();
		String words[] = { "a", "b", "ba", "bca", "bda", "bcda" };
		String words2[] = { "", "a", "bcdad", "adghjkk" };
		System.out.println(longest_chain(words));
	}
}
