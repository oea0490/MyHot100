package Hot100.Hash;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0 ; i < n ; i++){
            map.put(nums[i], i);
        }
        for (int i = 0 ; i < n ; i++){
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i){
                ans[0] = i;
                ans[1] = map.get(temp);
                return ans;
            }
        }
        return ans;
    }
}
