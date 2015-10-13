package DynamicProgramming;

import java.util.*;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = m == 0 ? 0 : dungeon[0].length;
        int dp[][] = new int [m + 1][n + 1];
        dp[m -1][n] = 1;
        dp[m][n -1] = 1;
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for (int i = m -1 ; i >= 0; i--){
            for (int j = n -1; j >= 0; j--){
                int need = Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = need <= 0 ? 1 : need;
            }
        }
        return dp[0][0];
    }
	
	public static void main (String args[]){
		DungeonGame dg = new DungeonGame();
		int[][] dungeon = {{0,-3}};
		System.out.println(dg.calculateMinimumHP(dungeon));
	}
}
