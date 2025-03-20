package Hot100.MultiDynamicProgramming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        //定义dp[i][j]表示下标i到下标j位置的子串是否为回文串
        //状态转移：dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
        //初始状态：dp[i][i] = true;
        boolean[][] dp = new boolean[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        //状态转移
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (i + 1 <= j -1) {
                    dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                }else{
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
