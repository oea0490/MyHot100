package Hot100.DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return nums[0];
        //定义dp[i]为盗窃第i间房的最大利润
        //状态转移方程：dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        //初始状态：dp[0] = nums[0] , dp[1] = Math.max(nums[0] , nums[1]);
        int[] dp = new int[n];
        //初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        //状态转移
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i] , dp[i-1]);
        }
        return dp[n - 1];
    }
}
