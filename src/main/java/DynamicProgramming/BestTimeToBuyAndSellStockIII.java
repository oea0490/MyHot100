package DynamicProgramming;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        //定义dp[i][j]为第i天结束,j状态的最大利润
        //状态：0表示未进行操作、1表示进行一次买、2表示进行一次买一次卖、3表示完成一笔交易买第二次、5表示完成两笔交易
        //状态转移方程：dp[i][0] = 0;
        //状态转移方程：dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] - price[i]);
        //状态转移方程：dp[i][2] = Math.max(dp[i-1][2] , dp[i-1][1] + price[i]);
        //状态转移方程：dp[i][3] = Math.max(dp[i-1][3] , dp[i-1][2] - price[i]);
        //状态转移方程：dp[i][4] = Math.max(dp[i-1][4] , dp[i-1][3] + price[i]);
        //初始状态：dp[0][0] = 0; dp[0][1] = -price[0]; dp[0][2] = 0; dp[0][3] = -price[0]; dp[0][4] = 0;
        int[][] dp = new int[n][5];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        //状态转移
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[n - 1][4];
    }
}
