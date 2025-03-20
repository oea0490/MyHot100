package Hot100.DynamicProgramming;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        if (n < 2) return 0;
        int maxLen = 0;
        //定义dp[i]表示下标i位置为结尾的最长有效括号长度
        //状态转移方程: s[i-1] == '(' && s[i] == ')' dp[i] = dp[i-2] + 2
        //            s[i-1] == ')' && s[i] == ')' dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
        //初始状态: dp[0] = 0;
        int[] dp = new int[n];
        //初始化
        dp[0] = 0;
        //状态转移
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else if (s.charAt(i - 1) == ')') {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                        } else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
