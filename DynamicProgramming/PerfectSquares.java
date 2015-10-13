package DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        int dp [] = new int [n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i =0; i < n ; i++){
            for (int j = 1; j <= n/2; j ++){
               dp [i + j * j] = Math.min(dp[i]+1, dp[i+j*j]); 
            }
        }
        return dp[n];
    }
}
