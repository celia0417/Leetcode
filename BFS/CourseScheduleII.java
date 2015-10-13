package BFS;

import java.util.*;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
		int matrix[][] = new int[numCourses][numCourses];
		int indegree[] = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0) {
				indegree[ready]++;
			}
			matrix[pre][ready] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		int cnt = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			res[cnt] = course;
			cnt++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		if (cnt != numCourses) {
			return new int[0];
		} else {
			return res;
		}
	}

	public static void main(String args[]) {
		CourseScheduleII cs = new CourseScheduleII();
		int prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int res[] = cs.findOrder(4, prerequisites);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
