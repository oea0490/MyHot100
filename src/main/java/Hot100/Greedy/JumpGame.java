package Hot100.Greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxPosition = 0;
        int curPosition = 0;
        int n = nums.length;
        while (curPosition < n && curPosition <= maxPosition){
            maxPosition = Math.max(maxPosition, curPosition + nums[curPosition]);
            curPosition++;
        }
        return curPosition == n;
    }
}
