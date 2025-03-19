package Hot100.Substring;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int pre = 0;
        //map记录key为前缀和，value为出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(pre, 1);
        for (int num : nums){
            pre += num;
            if (map.containsKey(pre - k)){
                ans += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}
