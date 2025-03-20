package Hot100.MultiDynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //定义dp[i][j]表示text1[0...i-1]和text2[0...j-1]的最长公共子序列长度
        //状态转移方程：if(text1[i] == text2[j]) dp[i][j] = dp[i-1][j-1] + 1;
        //                                否则 dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        //初始化：dp[i][0] =0, dp[0][j] = 0
        int[][] dp = new int[m + 1][n + 1];
        //初始化
//        for (int i = 0; i < m + 1; i++) {
//            dp[i][0] = 0;
//        }
//        for (int j = 0; j < n + 1; j++) {
//            dp[0][j] = 0;
//        }
        //状态转移
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
