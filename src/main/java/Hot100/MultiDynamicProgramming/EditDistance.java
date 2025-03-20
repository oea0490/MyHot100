package Hot100.MultiDynamicProgramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //定义dp[i][j]表示word1[0...i-1]和word2[0...j-1]的最小编辑距离
        //状态转移方程：dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1;
        //初始状态：dp[0][j] = j;dp[i][0] = i;
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        //状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int min = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = Math.min(min, dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
