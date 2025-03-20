package Hot100.DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int maxLen = 1;
        //定义dp[i]为以nums[i]结尾的最长递增子序列的长度
        //状态转移方程：dp[i] = max(dp[j]) + 1, 0 <= j < i && nums[j] < nums[i]
        //初始状态：dp[i] = 1;
        int[] dp = new int[n];
        //初始化
        Arrays.fill(dp, 1);
        //状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLen = Math.max(maxLen, dp[i]);
                }
            }
        }
        return maxLen;
    }
}
