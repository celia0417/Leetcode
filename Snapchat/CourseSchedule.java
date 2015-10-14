package Snapchat;

import java.util.*;

public class CourseSchedule {
	private int V;
	private int E;
	private List<Integer>[] adj;
	private boolean hasCycle;
	private boolean[] marked;
	private boolean[] onStack;

	public CourseSchedule(int n, int[][] edges) {
		this.V = n;
		this.E = edges.length;
		adj = (List<Integer>[]) new List[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<Integer>();
		for (int i = 0; i < E; i++) {
			int v = edges[i][1];
			int w = edges[i][0];
			adj[v].add(w);
		}
	}

	public boolean hasTopologicalOrder() {
		marked = new boolean[V];
		onStack = new boolean[V];
		for (int v = 0; v < V; v++) {
			if (!marked[v])
				dfs(v);
		}
		return !hasCycle;
	}

	private void dfs(int v) {
		marked[v] = true;
		onStack[v] = true;
		for (int w : adj[v]) {
			if (hasCycle)
				return;
			else if (!marked[w])
				dfs(w);
			else if (onStack[w])
				hasCycle = true;
		}
		onStack[v] = false;
	}

	public boolean canFinish(int numCourses, int[][] prerequistes) {
		CourseSchedule cs = new CourseSchedule(numCourses, prerequistes);
		return cs.hasTopologicalOrder();
	}

	// dfs
	private ArrayList<Integer>[] graph;
	private boolean visited[];
	private boolean cycle;

	public boolean canFinish2(int numCourses, int[][] prerequisites) {
		graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
		visited = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i])
				dfs2(i);
		}
		return !cycle;
	}

	public void dfs2(int v) {
		visited[v] = true;
		for (int i = 0; i < graph[v].size(); i++) {
			int w = graph[v].get(i);
			if (cycle)
				return;
			else if (!visited[w])
				dfs2(w);
			else
				cycle = true;
		}
		visited[v] = false;
	}

	// bfs
	public boolean canFinish3(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
		int[] degree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<Integer>();
		int count = 0;
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<Integer>();

		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
			degree[prerequisites[i][0]]++;
		}
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				count++;
			}
		}

		while (queue.size() != 0) {
			int v = queue.poll();
			for (int i = 0; i < graph[v].size(); i++) {
				int pointer = graph[v].get(i);
				degree[pointer]--;
				if (degree[pointer] == 0) {
					queue.add(pointer);
					count++;
				}
			}
		}
		if(count == numCourses)
			return true;
		else
			return false;
	}
}
