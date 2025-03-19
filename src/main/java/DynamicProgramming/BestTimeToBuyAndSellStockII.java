package DynamicProgramming;


public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        //定义dp[i][0]为第i天交易完后没有股票的最大利润
        //定义dp[i][1]为第i天交易完后　有股票的最大利润
        //状态转移方程：dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
        //状态转移方程：dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i])
        //初试状态：dp[0][0] = 0, dp[0][1] = -prices[0]
        int[][] dp = new int[prices.length][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        //状态转移
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
