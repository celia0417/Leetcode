package BFS;

import java.util.*;

public class FindAncestor {
//	public List<String> findAncestor(String str, int n) {
//		List<String> res = new ArrayList<String>();
//		ArrayList<ArrayList<String>> allRelations = allRelations(str);
//
//		// find root
//		Map<String, Integer> record = new HashMap<String, Integer>();
//		for (int i = 0; i < allRelations.size(); i++) {
//			String child = allRelations.get(i).get(1);
//			String parent = allRelations.get(i).get(0);
//			if (record.containsKey(child))
//				record.put(child, record.get(child) + 1);
//			else if (!record.containsKey(child))
//				record.put(child, 1);
//			if (!record.containsKey(parent))
//				record.put(parent, 0);
//		}
//		String root = null;
//		for (String key : record.keySet()) {
//			if (record.get(key) == 0) {
//				root = key;
//			}
//		}
//		if (root == null) return res;
//		Queue<String> q = new LinkedList<>();
//		Map<String, Integer> map = new HashMap<>();
//		map.put(root, 1);
//		q.offer(root);
//		while (!q.isEmpty()) {
//			int dep = map.get(q.peek());
//			if (dep == n) break;
//			String cur = q.poll();
//	        for(int i = 0; i < allRelations.size(); i++){
//	            if(cur.equals(allRelations.get(i).get(0))){
//	            	String child = allRelations.get(i).get(1);
//	            	q.offer(child);
//	            	map.put(child, dep + 1);
//	            }
//	        }
//		}
//		for (int i = 0; i < q.size(); i++){
//			res.add(q.peek());
//		}
//		return res;
//	}
//
//	private ArrayList<ArrayList<String>> allRelations(String str) {
//		ArrayList<ArrayList<String>> allRelations = new ArrayList<ArrayList<String>>();
//		ArrayList<String> lineRelations = lineRelations(str);
//
//		for (int i = 0; i < lineRelations.size(); i++) {
//			String[] temp = lineRelations.get(i).split("->");
//			ArrayList<String> eachLine = new ArrayList<String>(Arrays.asList(temp));
//			allRelations.add(eachLine);
//		}
//		return allRelations;
//	}
//
//	private ArrayList<String> lineRelations(String str) {
//		int i;
//		ArrayList<String> lineRelations = new ArrayList<String>();
//		String[] lines = str.split("/");
//		for (i = 0; i < lines.length; i++) {
//			lineRelations.add(lines[i]);
//		}
//		return lineRelations;
//	}
//	
//	public static void main(String args[]){
//		FindAncestor fa = new FindAncestor();
//		List<String> res = fa.findAncestor("1->2/2->3/3->4/2->5/1->6", 1);
//		for (String s: res){
//			System.out.println(s);
//		}
//	}
	
	
	
	public static void main(String[] args)  {
//	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s = "Frank->Mary,Mary->Sam,Mary->Bob,Sam->Katie,Sam->Pete,Bob->John,3";
	    String input [] = null;
//	    while ((s = in.readLine()) != null) {
	        input = s.split(",");
	    //   System.out.println(s);
//	    }
	    ArrayList<ArrayList<String>> allRelations = new ArrayList<ArrayList<String>>();
	    ArrayList<String> lineRelations = new ArrayList<String>();
	    for (int i = 0; i < input.length -1; i ++){
	        lineRelations.add(input[i]);
	    }
	    int n = Integer.parseInt (input[input.length -1 ]);
	    
	    for (int i = 0; i < lineRelations.size(); i++){
	        String[] temp = lineRelations.get(i).split("->");
	        ArrayList<String> eachLine = new ArrayList<String>(Arrays.asList(temp));
	        allRelations.add(eachLine);
	    }
	    findAncestor(allRelations, n);
	  }
	  
	  public static void findAncestor(ArrayList<ArrayList<String>> allRelations, int n){
	    Map<String, Integer> record = new HashMap<String, Integer>();
	    for (int i = 0; i < allRelations.size(); i++){
	        String child = allRelations.get(i).get(1);
	        String parent = allRelations.get(i).get(0);
	        if (record.containsKey(child))
	            record.put(child, record.get(child) +1);
	        else if (!record.containsKey(child))          
	            record.put(child, 1);
	        if (!record.containsKey(parent))
	            record.put(parent, 0);
	    }
	    // deal wiht the data : split, 
	    // form the graph
	    // find root
	    // bfs
	    // sort result 
	    String root = null;
	    for (String key : record.keySet()){
	        if (record.get(key) == 0){
	            root = key;
	        }
	    }
	    if (root == null) return;
	    Queue<String> q = new PriorityQueue<String>();
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put(root,1);
	    q.offer (root);
	    while (!q.isEmpty()){
	        int dep = map.get(q.peek());
	        if (dep == n) break;
	        String cur = q.poll();
	        for (int i = 0; i < allRelations.size(); i++){
	            if (cur.equals(allRelations.get(i).get(0))){
	                String child = allRelations.get(i).get(1);
	                q.offer(child);
	                map.put(child, dep+1);
	            }
	        }
	    }
	    String res [] = new String [q.size()];
	    int index = 0;
	    for (String s : q){
	       res[index ++] = s;
	    }
	    Arrays.sort(res);
	    for (int i = 0 ; i < res.length; i++){
	    	System.out.print(res[i]);
	    	System.out.print(",");
	    }
	  } 
}
