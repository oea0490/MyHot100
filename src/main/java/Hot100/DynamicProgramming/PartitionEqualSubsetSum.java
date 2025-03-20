package Hot100.DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0 ; i < n ; i++){
            sum += nums[i];
            maxNum = Math.max(maxNum, nums[i]);
        }
        if (sum % 2 != 0) return false;
        if (maxNum > sum / 2) return false;
        int target = sum / 2;
        //定义dp[i][j]表示前i个数能否找到一个子集，其和为j
        //状态转移：dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]]
        //初始状态：dp[i][0] = true;
        boolean[][] dp = new boolean[n + 1][target + 1];
        //初始化
        Arrays.fill(dp[0], false);
        for (int i = 0 ; i <= n ; i++){
            dp[i][0] = true;
        }
        //状态转移
        for (int i = 1 ; i <= n ; i++){
            for (int j = 1 ; j <= target ; j++){
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}
