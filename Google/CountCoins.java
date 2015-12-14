package Google;

import java.util.*;

public class CountCoins {
	private int solution(int[] coins,int amount, int[] sol){  
		int []dp = new int [amount + 1];
		dp[0] = 0;
		for (int cents = 1; cents <= amount; cents++){
			int min = cents;
			for (int i = 0; i < coins.length; i ++){
				if (cents >= coins[i] ){
					int temp = dp[cents - coins[i]] + 1;
					if (temp < min) {
						min = temp;
						sol[cents -1] = coins[i];
					}
				}
			}
			dp[cents] = min;
			System.out.println("value: "+ cents + " " + dp[min]);
		}
		return dp[amount];
    } 
	
	public static void main (String args[]){
		CountCoins cc = new CountCoins();
		int[] coins = new int [] {2,3,5};
		int amount = 23;
		int[] sol = new int [amount] ;
		System.out.println(cc.solution(coins, amount, sol));
		for (int i = amount - 1; i >= 0;){
			System.out.println(sol[i]);
			i = i - sol[i];
		}
		System.out.println((int) (Math.random() * 2));
	}
}
