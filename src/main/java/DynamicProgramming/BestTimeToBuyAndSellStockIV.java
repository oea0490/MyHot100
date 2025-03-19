package DynamicProgramming;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        //定义dp[i][j]为第i天结束,j状态的最大利润
        //状态转移方程: j=0表示未进行操作        dp[i][0] = 0;
        //            j%2 = 1表示进行买操作    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1] - price[i]);
        //            j%2 = 0表示进行卖操作    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-1] + price[i]);
        //初始状态: dp[0][0] = 0;dp[0][1] = -price[0];dp[0][2] = 0;
        int[][] dp = new int[n][2 * k + 1];
        //初始化
        for(int j = 0 ; j < 2 * k + 1 ; j++){
            if(j % 2 == 0){
                dp[0][j] = 0;
            }else{
                dp[0][j] = -prices[0];
            }
        }
        //状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
               }
            }
        }
        return dp[n - 1][2 * k];
    }
}
