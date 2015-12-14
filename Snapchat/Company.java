package Snapchat;

import java.util.*;

public class Company {
	static class Node {
		public Node() {
		neighbors = new HashSet<Node>();
		                }

		Set<Node> neighbors;
	}

	static class Graph {

		Set<Node> nodes;

		public Graph() {
			nodes = new HashSet<Node>();
		                }

		public void addEdge(Node a, Node b) {
			a.neighbors.add(b);
			b.neighbors.add(a);
			nodes.add(a);
			nodes.add(b);
		              }

		public boolean isBipartite(Graph g) {
			// implement here
			
			Map<Node, Integer> indeed = new HashMap<Node, Integer>();
			for (Node node : g.nodes){
				for(Node n : node.neighbors){
					
				}
			}
		return false;
		                }
	}

	public static void main(String[] args) {
		 Node a = new Node();
		Node b = new Node();
		Node c = new Node();

		Graph g = new Graph();

		g.addEdge(a, b);
		g.addEdge(b, c);
		g.addEdge(c, a);
		System.out.println("is bipartite: " + g.isBipartite());
		        }
}
