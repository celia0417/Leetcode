package DynamicProgramming;

public class BestTimeBuyStock {
	public int maxProfit(int k, int[] prices) {
        int n = prices.length, max = 0;
        if (k > n /2){
            for (int i = 1; i < prices.length; i++){
                max = Math.max(max, max + prices[i] - prices[i-1]);
            }  
            return max;
        }
        int[] local = new int [k + 1];
        int[] global = new int [k + 1];
        for (int i = 0; i < n - 1 ; i++){
            int dif = prices[i + 1] - prices[i];
            for (int j = k; j >= 1; j--){
                local[j] = Math.max(global[j - 1] + Math.max(0, dif), local[j] + dif);
                global[j] = Math.max(global[j], local[j]);
            }
        }
        return global[k];
    }
	
	public static void main (String args[]){
		BestTimeBuyStock btb = new BestTimeBuyStock();
		btb.maxProfit(3, new int [] {3,0,5,8,2,-1,8});
	}
}
