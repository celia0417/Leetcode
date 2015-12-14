package Snapchat;
import java.util.*;

public class Bipartite {
	public static boolean bipartite(Set<Node> nodes){
		
		if(nodes.isEmpty()){return true;}
		Set<Node> a = new HashSet<Node>();
		Set<Node> b = new HashSet<Node>();
		Set<Node> copyNodes = new HashSet<Node>(nodes);
		for(Node n: nodes){
			a.clear();
			b.clear();
			Queue<Node> queue = new LinkedList<Node>();
			queue.offer(n);
			Set<Node> visited = new HashSet<Node>();
			a.add(n);
			int level = 0;
			while(!queue.isEmpty()) {
				int size = queue.size();
				for(int i = 0; i < size; i++) {
					Node temp = queue.poll();
					visited.add(temp);
					for(Node toAdd: temp.neighbors){ 
						if(!visited.contains(toAdd)){
							queue.add(toAdd);
						}  //judge visited!!!
						if(level % 2 == 0){
							if(a.contains(toAdd)){
								return false;
							}
							b.add(toAdd);
						}
						else{
							if(b.contains(toAdd)){
								return false;
							}
							a.add(toAdd);
						}
					}
					copyNodes.remove(temp);
				}
				level++;
			}
//			return bipartite(copyNodes);
		}
		return true;
	}
	
	public static void main (String args[]){
		Bipartite bp = new Bipartite();
		Node n1 = new Node(1);
		Node n2 = new Node (2);
		Node n3 = new Node (3);
		Node n4 = new Node (4);
		n1.neighbors.add(n2);
		n2.neighbors.add(n3);
//		n3.neighbors.add(n1);
		Set<Node> nodes = new HashSet<Node>();
		nodes.addAll(Arrays.asList(n1, n2, n3,n4));
		System.out.println(bp.bipartite(nodes));
	}
}

class Node {
	int label;
	List<Node> neighbors;

	Node(int x) {
		label = x;
		neighbors = new ArrayList<Node>();
	}
}

