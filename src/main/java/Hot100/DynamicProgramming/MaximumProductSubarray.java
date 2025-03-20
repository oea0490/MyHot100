package Hot100.DynamicProgramming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        //定义maxDP[i]为以nums[i]结尾的子数组的最大乘积
        int[] maxDP = new int[n];
        //定义minDP[i]为以nums[i]结尾的子数组的最小乘积
        int[] minDP = new int[n];
        //初始化
        maxDP[0] = nums[0];
        minDP[0] = nums[0];
        //状态转移
        for (int i = 1; i < n; i++) {
            maxDP[i] = Math.max(Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]), nums[i]);
            minDP[i] = Math.min(Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]), nums[i]);
            maxProduct = Math.max(maxProduct, maxDP[i]);
        }
        return maxProduct;
    }
}
