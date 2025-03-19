package Hot100.Hash;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;

        for (int num : set) {
            if(set.contains(num - 1)) continue;
            int curLen = 1;
            int curNum = num;
            while (set.contains(curNum + 1)) {
                curLen += 1;
                curNum += 1;
            }
            maxLen = Math.max(maxLen, curLen);
        }

        return maxLen;
    }
}