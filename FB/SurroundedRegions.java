package FB;

import java.util.*;
public class SurroundedRegions {
	public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        for (int i = 0; i < m; i++){
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n-1);
        }
        for (int j = 0; j < n; j++){
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
               if (board[i][j] == 'O') board[i][j] ='X';
               else if (board[i][j] == '#') board[i][j] ='O';
            }
        }
    }
    
    public void dfs(char[][] grid, int i, int j){
        Queue<Integer> q = new LinkedList<>();
        q.add(i * grid[0].length + j);
        while (!q.isEmpty()){
            int cur = q.poll();
            int x = cur / grid[0].length;
            int y = cur % grid[0].length;
            grid[x][y] = '#';
            int[] xCor = new int []{1,-1,0,0};
            int[] yCor = new int []{0,0,1,-1};
            for (int index = 0; index < xCor.length; index++){
                addUp(grid, x + xCor[index], y + yCor[index], q);
            }
        }
    }
    
    public void addUp(char[][] grid, int x, int y, Queue<Integer> q){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 'O') return;
        grid[x][y] = '#';
        q.offer(x * grid[0].length + y);
    }
    
    public static void main (String args[]){
    	SurroundedRegions sr = new SurroundedRegions();
    	sr.solve(new char [][] {{'O','O','O'},{'O','O','O'},{'O','O','O'}});
    }
}
