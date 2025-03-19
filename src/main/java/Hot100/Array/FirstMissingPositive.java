package Hot100.Array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //第一次遍历,将数放在自己对应的位置上
        for (int i = 0 ; i < n ; i++){
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        //第二次遍历,找到第一个不在自己对应位置上的数
        for (int i = 0 ; i < n ; i++){
            if (nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
}