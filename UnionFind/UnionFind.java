package UnionFind;
import java.util.*;
public class UnionFind {
	public boolean validTree(int n, int[][] edges) {
        int [] record = new int[n];
        Arrays.fill(record, -1);
        for (int i = 0; i < edges.length; i++){
            int x = find(record, edges[i][0]);
            int y = find(record, edges[i][1]);
            if (x == y) return false;
            record[x] = y;
        }
        return n - 1 == edges.length;
    }
    
    public int find (int[] record, int num){
        if (record[num] == -1) return num;
        return find(record, record[num]);
    }
    
    public static void main (String args[]){
    	UnionFind uf = new UnionFind();
    	System.out.println(uf.validTree(10, new int [][]{{3,4},{4,9},{8,0},{2,4},{5,6},{5,9},{7,3},{4,8},{6,1}}));
    }
}
