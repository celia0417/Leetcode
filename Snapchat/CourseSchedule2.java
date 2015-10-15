package Snapchat;

import java.util.*;

public class CourseSchedule2 {
	boolean hasCycle = false;

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		boolean visited[] = new boolean[numCourses];
		boolean onStack[] = new boolean[numCourses];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (!visited[i])
				dfs(visited, onStack, graph, i, stack);
		}
		int[] res = new int[numCourses];
		if (hasCycle)
			return new int[0];
		else {
			for (int i = 0; i < res.length; i++) {
				res[i] = stack.pop();
			}
		}
		return res;
	}

	public void dfs(boolean[] visited, boolean onStack[], List<Integer>[] graph, int course, Stack<Integer> stack) {
		visited[course] = true;
		onStack[course] = true;
		for (int i = 0; i < graph[course].size(); i++) {
			int w = graph[course].get(i);
			if (hasCycle)
				return;
			else if (!visited[w])
				dfs(visited, onStack, graph, w, stack);
			else if (onStack[w])
				hasCycle = true;
		}
		stack.push(course);
		onStack[course] = false;
	}
	
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = (ArrayList<Integer>[]) new ArrayList[numCourses];
		int[] degree = new int[numCourses];
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] res = new int[numCourses];
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
        int cnt = 0;
		while (queue.size() != 0) {
			int v = queue.poll();
			res[cnt++] = v;
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
			return res;
		else
			return new int[0];
    }

	public static void main(String args[]) {
		CourseSchedule2 cs = new CourseSchedule2();
//		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[][] prerequisites = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 } };

		// int[][] prerequisites = {{1,0}};
		int[] res = cs.findOrder2(4, prerequisites);
		for (int r : res) {
			System.out.println(r);
		}
	}
}
