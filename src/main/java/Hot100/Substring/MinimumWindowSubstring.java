package Hot100.Substring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    Map<Character, Integer> smap;
    Map<Character, Integer> tmap;
    public String minWindow(String s, String t) {
        //初始化tmap
        tmap = new HashMap<>();
        for (char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        smap = new HashMap<>();
        int n = s.length();
        int left = 0, right = 0;
        int start = 0, minLen = Integer.MAX_VALUE;
        while (right < n){
            //入滑动窗口
            char cur = s.charAt(right);
            if (tmap.containsKey(cur)){
                smap.put(cur, smap.getOrDefault(cur, 0) + 1);
            }
            //更新答案
            while (check() && left <= right){
                if (right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }
                //出滑动窗口
                char leftCur = s.charAt(left);
                if (tmap.containsKey(leftCur)){
                    smap.put(leftCur, smap.get(leftCur) - 1);
                }
                left++;
            }
            right ++;
        }
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(start, start + minLen);
    }

    public boolean check(){
        for (Map.Entry<Character, Integer> entry : tmap.entrySet()){
            char key = entry.getKey();
            int val = entry.getValue();
            if (smap.containsKey(key) && smap.get(key) >= val){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}
