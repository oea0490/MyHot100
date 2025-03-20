package Hot100.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
//        //定义dp[i][j]为使用硬币i个，能够达到金额j的最少硬币数
//        //状态转移方程：dp[i][j] = min(dp[i-1][j],dp[i][j-coins[i-1]]+1)
//        //初始状态：dp[0][j] = Integer.MAX_VALUE,dp[i][0] = 0;
//        int n = coins.length;
//        Arrays.sort(coins);
//        int[][] dp = new int[n + 1][amount + 1];
//        //初始化
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(dp[i], 0x3f3f3f3f);
//            dp[i][0] = 0;
//        }
//        //状态转移
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= amount; j++) {
//                if (j < coins[i - 1]) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
//                }
//            }
//        }
//        if (dp[n][amount] == 0x3f3f3f3f) return -1;
//        return dp[n][amount];

        //优化空间复杂度
        //定义dp[j]为能够达到金额j的最少硬币数
        //状态转移方程：dp[j] = min(dp[j],dp[j-coins[i - 1]]+1)
        //初始状态：dp[0] = 0,dp[j] = Integer.MAX_VALUE;
        int n = coins.length;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        //初始化
        Arrays.fill(dp, 0x3f3f3f3f);
        dp[0] = 0;
        //状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i - 1]] + 1);
            }
        }

        if (dp[amount] == 0x3f3f3f3f) return -1;
        return dp[amount];
    }
}
