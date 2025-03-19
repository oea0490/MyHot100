package DynamicProgramming;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //定义dp[i][j]为下标i到下标j的最长回文子序列长度
        //状态转移方程：if(s[i] == s[j]) dp[i][j] = dp[i+1][j-1] + 2;
        //                        否则 dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
        //初始化：dp[i][i] = 1;
        int[][] dp = new int[n][n];
        //初始状态
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            //ans = Math.max(ans, dp[i][i]);
        }
        //状态转移
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
           }
        }
        return dp[0][n - 1];
    }
}
