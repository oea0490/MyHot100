package Hot100.Array;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1 ; i < n ; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}