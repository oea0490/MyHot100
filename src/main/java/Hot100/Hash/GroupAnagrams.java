package Hot100.Hash;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = String.valueOf(strArr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        for (List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
    }
}