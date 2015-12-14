package Snapchat;

import java.util.*;

public class FindSum {

	public int sum(Wrapper w) {
		int sum = 0;
		Queue<Wrapper> q = new LinkedList<Wrapper>();
		Queue<Integer> dep = new LinkedList<Integer>();
		Set<Wrapper> visited = new HashSet<Wrapper>();
		q.offer(w);
		dep.offer(1);
		visited.add(w);
		while (!q.isEmpty()) {
			Wrapper cur = q.poll();
			int d = dep.poll();
			sum += d * cur.val;
			for (Wrapper n : w.nodes){
				if (!visited.contains(n)){
					q.offer(n);
					visited.add(n);
					dep.add(d+1);
				}
			}
		}
		return sum;
	}
	
	public int findDep(Wrapper w, int dep){
		if (w == null) return 0;
		
		for (Wrapper n : w.nodes){
			findDep(n, dep + 1) ;
		}
		
		return dep;
	}
}

class Wrapper {
	int val;
	List<Wrapper> nodes;
}