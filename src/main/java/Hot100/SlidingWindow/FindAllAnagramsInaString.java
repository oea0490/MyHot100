package Hot100.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInaString {
    Map<Character, Integer> smap;
    Map<Character, Integer> pmap;
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        pmap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pmap.put(c, pmap.getOrDefault(c, 0) + 1);
        }

        int n = s.length();
        smap = new HashMap<>();
        int left = 0, right = 0;
        while (right < n) {
            //入滑动窗口
            char cur = s.charAt(right);
            smap.put(cur, smap.getOrDefault(cur, 0) + 1);
            right ++;
            if(right < p.length()){
                continue;
            }
            //更新答案
            if(check()){
                ans.add(left);
            }
            //出滑动窗口
            char leftCur = s.charAt(left);
            smap.put(leftCur, smap.getOrDefault(leftCur, 0) - 1);
            left ++;
        }
        return ans;
    }

    public boolean check() {
        for (Map.Entry<Character, Integer> entry : pmap.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (smap.containsKey(key) && smap.get(key) == val){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
