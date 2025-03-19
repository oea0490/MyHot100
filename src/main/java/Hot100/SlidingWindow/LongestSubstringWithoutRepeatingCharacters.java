package Hot100.SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while(right < n){
            char cur = s.charAt(right);
            while (set.contains(cur)){
                char leftCur = s.charAt(left);
                set.remove(leftCur);
                left++;
            }
            set.add(cur);
            maxLen = Math.max(maxLen, right - left + 1);
            right ++;
        }
        return maxLen;
    }
}