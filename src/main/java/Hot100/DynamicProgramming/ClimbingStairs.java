package Hot100.DynamicProgramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        //定义dp[i]为爬到第i阶的方法数
        //状态转移方程：dp[i] = dp[i-1] + dp[i-2]
        //初始状态：dp[0] = 1, dp[1] = 1
        int[] dp = new int[n + 1];
        //初始化
        dp[0] = 1;
        dp[1] = 1;
        //状态转移
        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
