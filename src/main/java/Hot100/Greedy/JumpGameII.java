package Hot100.Greedy;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int curEnd = 0;
        int maxPos = 0;
        int steps = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            maxPos = Math.max(maxPos, i + nums[i]);
            if(i == curEnd){
                curEnd = maxPos;
                steps++;
            }
        }
        return steps;
    }
}
