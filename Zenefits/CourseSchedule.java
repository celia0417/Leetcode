package Zenefits;

import java.util.*;

public class CourseSchedule {
	private boolean cycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> onStack = new HashSet<>();
        for (int i = 0; i < numCourses; i++){
            if (!visited.contains(i)){
                dfs(graph, visited, onStack, i);   
            }
        }
        return !cycle;
    }
    
    public void dfs(Map<Integer, Set<Integer>> graph, Set<Integer> visited, Set<Integer> onStack, int cur){
        visited.add(cur);
        onStack.add(cur);
        for(int i : graph.get(cur)){
            if (cycle) return;
            if (!visited.contains(i)) dfs(graph, visited, onStack, i);
            else if (onStack.contains(i)) cycle = true;
        }
        onStack.remove(cur);
    }
    
    public static void main (String args[]){
    	CourseSchedule cs = new CourseSchedule();
    	System.out.println(cs.canFinish(3, new int [][] {{2,0},{2,1}}));
    }
}
