package Hot100.DynamicProgramming;

import java.util.Arrays;

public class PerfectSquares {
    public int numSquares(int n) {
        //定义dp[i]为和为i的最小完全平方数个数
        //状态转移方程：dp[i] = min(dp[i], dp[i - j*j] + 1)
        //初始状态：dp[0] = 0,dp[i * i] = 1;
        int[] dp = new int[n + 1];
        //初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        //状态转移
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
