package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++){
            if (board[0][i] == '0'){
                bfs(board, 0, i);
            }
            if (board[board.length - 1][i] == '0'){
                bfs(board, board.length - 1, i);
            }
        }
        for (int i = 0; i < board.length; i++){
            if (board[i][0] == '0'){
                bfs(board, i, 0);
            }
            if (board[i][board[0].length] == '0'){
                bfs(board, i, board[0].length - 1);
            }
        }
        
        for (int i =0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '0'){
                    board[i][j] = 'X';
                }
            }
        }
        
        for (int i =0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == '#'){
                    board[i][j] = '0';
                }
            }
        }
    }
    
    public void bfs(char[][] board, int i, int j){
    	Queue<Integer> q = new LinkedList<>();
        q.add(i * board[0].length + j);
        while (!q.isEmpty()){
            int pos = q.poll();
            int m = pos / board.length, n = pos % board.length;
            if (board[i][j] == '0'){
                board[i][j] = '#';
                if (m - 1 >= 0 ) q.add((m-1) * board.length + n);
                if (m + 1 < board.length) q.add((m+1) * board.length + n);
                if (n - 1 >= 0) q.add(m * board.length + n - 1);
                if (n + 1 < board[0].length) q.add(m * board.length + n + 1);
            }
        }
    }
}
