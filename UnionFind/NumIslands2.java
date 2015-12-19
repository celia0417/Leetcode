package UnionFind;

import java.util.*;

public class NumIslands2 {
private int [][] dir = {{0,1}, {0,-1},{-1,0},{1,0}};
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int [] roots = new int[m * n];
        Arrays.fill(roots, - 1);
        List<Integer> res = new ArrayList<>();
        
        for (int[] position : positions){
            roots[position[0] * n + position[1]] = position[0] * n + position[1];
            int count = res.isEmpty()? 1 : res.get(res.size()-1) + 1;
            
            for (int i =0; i < dir.length; i++){
                int newX = dir[i][0] + position[0];
                int newY = dir[i][1] + position[1];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                int root1 = find (newX * n + newY, roots);
                int root2 = roots[position[0] * n + position[1]];
                if (root1 != root2) count --;
                roots[root1] = root2;
            }
            res.add(count);
        }
        return res;
    }
    
    public int find(int target, int[] roots){
       if (roots[target] == target ) return target;
       roots[target] = find (roots[target], roots);
       return roots[target];
    }
    
    public static void main (String args[]){
    	NumIslands2 ni = new NumIslands2();
    	List<Integer> res = ni.numIslands2(3, 3, new int [][] {{0,0},{0,1},{1,2},{2,1}});
    	for (int i : res){
    		System.out.println(i);
    	}
    }
}
