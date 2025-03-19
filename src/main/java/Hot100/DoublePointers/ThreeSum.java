package Hot100.DoublePointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0 ; first < n ; first++){
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            int third = n - 1;
            int target = 0 - nums[first];
            for (int second = first + 1 ; second < third ; second++){
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                while (second < third && nums[second] + nums[third] > target) third--;
                if (second == third) break;
                if (nums[second] + nums[third] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}
