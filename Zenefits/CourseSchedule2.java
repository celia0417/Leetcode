package Zenefits;

import java.util.*;

public class CourseSchedule2 {
	private Stack<Integer> stack = new Stack<>();
	private boolean cycle;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
		int[] res = new int[numCourses];
		boolean visited[] = new boolean[numCourses];
		boolean onStack[] = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				dfs(graph, visited, onStack, i);
			}
		}
		int cnt = 0;
		for (int i : stack) {
			res[cnt++] = i;
		}
		return res;
	}

	public void dfs(List<Integer>[] graph, boolean visited[], boolean[] onStack, int v) {
		visited[v] = true;
		onStack[v] = true;
		for (int i = 0; i < graph[v].size(); i++) {
			int w = graph[v].get(i);
			if (cycle)
				return;
			else if (!visited[w])
				dfs(graph, visited, onStack, v);
			else if (onStack[w])
				cycle = true;
		}
		stack.push(v);
		onStack[v] = false;
	}
}
