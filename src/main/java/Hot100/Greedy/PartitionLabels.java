package Hot100.Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        //map用来记录每个字符出现的最后位置
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++){
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end){
                ans.add(end - start + 1);
                start = i + 1;
            }
        }
        return ans;
    }
}
