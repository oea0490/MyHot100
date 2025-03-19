package Hot100.Array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int[] preMulti = new int[n];
        int[] postMulti = new int[n];
        //预处理
        preMulti[0] = 1;
        for (int i = 1 ; i < n ; i++){
            preMulti[i] = preMulti[i - 1] * nums[i - 1];
        }
        postMulti[n - 1] = 1;
        for (int i = n - 2 ; i >= 0 ; i--){
            postMulti[i] = postMulti[i + 1] * nums[i + 1];
        }
        //更新答案
        for (int i = 0 ; i < n ; i++){
            ans[i] = preMulti[i] * postMulti[i];
        }
        return ans;
    }
}