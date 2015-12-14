package Zenefits;

import java.util.*;

public class tokenizeAndCalculation {
	public Map<String, Integer> tokenCal(Map<String, String> input) {
	    Queue<String> q = new LinkedList<>(); 
	    Map<String, Integer> inDegree = new HashMap<>();
	    Map<String, List<String>> dict = new HashMap<>();
	    Map<String, Integer> res = new HashMap<>();
	    for (String curr : input.keySet()) {
	        String expr = input.get(curr);
	        //if (curr = input.get(expr)) continue;
	        if (tokenize(expr) == null) {
	            res.put(curr, Integer.parseInt(expr));
	        } else { 
	            List<String> strList = tokenize(expr);
	            inDegree.put(curr, strList.size());
	            for (String str : strList) {
	                List<String> dictList = dict.get(str);
	                if (dictList == null) {
	                      dictList = new ArrayList<>();
	                      dict.put(str, dictList);
	                }
	                dictList.add(curr);
	            }
	        }
	    }
	    for (String curr : input.keySet()) {
	        if (!inDegree.containsKey(curr)) {
	            q.add(curr);
	        }
	    }  
	    while (!q.isEmpty()) {
	        String curr = q.poll();
	        for (String str : dict.get(curr)) { 
	            int num = inDegree.get(str);
	            if (num == 1) { 
	                int currRes = cal(str, input, res);
	                res.put(str, currRes); 
	                inDegree.remove(str);
	                q.add(str);
	           } else {
	               inDegree.put(str, inDegree.get(str) - 1);
	           }
	       }
	   }   
	   return res;
	}

	public int cal(String s, Map<String, String> input, Map<String, Integer> res) {
	     Map<String, Integer> tbl = new HashMap<>();
	     List<String> strList = tokenize(input.get(s));
	     for (String str : strList) {
	        tbl.put(str, res.get(str));
	    }
	    return exprEval(s, tbl);
	}
}
