package Hot100.DoublePointers;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int point0 = 0;
        int point1 = 0;
        while(point1 < n){
            if(nums[point1] != 0){
                int tmp = nums[point0];
                nums[point0] = nums[point1];
                nums[point1] = tmp;
                point0++;
            }
            point1++;
        }
    }
}
