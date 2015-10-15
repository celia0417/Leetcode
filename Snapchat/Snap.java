package Snapchat;

import java.util.*;

public class Snap {
	List<Snap> next = new ArrayList<>();
	
	private Set<Snap> visited;
	private Set<Snap> onStack;
	private boolean cycle = false;
	public boolean hasCycle() {
		visited = new HashSet<Snap>();
		onStack = new HashSet<>();
		for (int i = 0 ; i < next.size(); i++){
			dfs(next.get(i));
		}
		return cycle;
	}

	public void dfs(Snap snap) {
		visited.add(snap);
		onStack.add(snap);
		for (int i = 0; i < snap.next.size(); i++) {
			Snap w = snap.next.get(i);
			if (cycle)
				return;
			else if (!visited.contains(w))
				dfs(w);
			else if (onStack.contains(w))
				cycle = true;
		}
		onStack.remove(snap);
	}
	
	public static void main (String args[]){
		Snap snap = new Snap();
		Snap s1= new Snap();
		Snap s2 = new Snap();
		s2.next = new ArrayList<>(Arrays.asList(snap));
		snap.next = new ArrayList<Snap>(Arrays.asList(s1, s2));
		System.out.println(snap.hasCycle());
	}
}
