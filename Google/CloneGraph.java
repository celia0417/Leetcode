package Google;

import java.util.*;

public class CloneGraph {
	private Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		return dfs(node);
	}

	public UndirectedGraphNode dfs(UndirectedGraphNode node) {
		if (map.containsKey(node.label))
			return map.get(node.label);
		
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(newNode.label, newNode);
		for (UndirectedGraphNode n : node.neighbors) {
			newNode.neighbors.add(dfs(n));
		}
		return newNode;
	}
	
	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null)
			return null;
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(newNode.label, newNode);
		dfs2(node, newNode);
		return newNode;
	}

	public void dfs2(UndirectedGraphNode node, UndirectedGraphNode newNode) {
		map.put(newNode.label, newNode);
		for (UndirectedGraphNode n : node.neighbors) {
			if (!map.containsKey(n.label)) {
				UndirectedGraphNode newN = new UndirectedGraphNode(n.label);
				newNode.neighbors.add(newN);
				dfs2(n, newN);
			}else {
				newNode.neighbors.add(map.get(n.label));
			}
		}
	}

	public static void main(String args[]) {
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode node = new UndirectedGraphNode(0);
		UndirectedGraphNode n2 = new UndirectedGraphNode(1);
		UndirectedGraphNode n3 = new UndirectedGraphNode(2);
		node.neighbors.add(n2);
		node.neighbors.add(n3);
		n2.neighbors.add(node);
		UndirectedGraphNode res = cg.cloneGraph2(node);
		for (UndirectedGraphNode un : res.neighbors) {
			System.out.println(un.label);
		}
		System.out.println(res.neighbors.get(0).neighbors.get(0).label);

	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
