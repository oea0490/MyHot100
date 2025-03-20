package Hot100.MultiDynamicProgramming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        //定义dp[i][j]为到达下标i,j的路径数
        //状态转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1];
        //初始状态：dp[0][0] = 1;dp[i][0] = 1;dp[0][j] = 1;
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
