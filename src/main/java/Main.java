import Hot100.BinarySearch.FindFirstAndLastPositionOfElementInSortedArray;
import Hot100.BinarySearch.SearchInsertPosition;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
//        String[] input = sc.nextLine().split(",");
//        int[] nums = new int[input.length];
//        for (int i = 0; i < input.length; i++) {
//            nums[i] = Integer.parseInt(input[i]);
//        }
        String s = sc.nextLine();
        List<String> res = solution.restoreIpAddresses(s);
        System.out.println(res);
    }
}

class Solution {
    Set<String> set = new HashSet<>(){{
        for(int i = 0; i <= 255; i++){
            add(String.valueOf(i));
        }
    }};
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        if(s.length() > 12 || s.length() < 4) return ans;
        dfs(s, 0, 0, new StringBuilder());
        return ans;
    }

    private void dfs(String s, int start, int count, StringBuilder sb){
        if(count == 4){
            if(start == s.length()){
                ans.add(sb.toString());
            }
            return;
        }

        for(int i = 0 ; i < 3 && start + i < s.length(); i++) {
            String str = s.substring(start, start + i + 1);
            if(set.contains(str)){
                //选择该步
                sb.append(str);
                if(count < 3) sb.append(".");
                //搜索下一步
                dfs(s, start + i + 1, count + 1, sb);
                //恢复现场
                if(count < 3) sb.delete(sb.length() - str.length() - 1, sb.length());
                else sb.delete(sb.length() - str.length(), sb.length());
            }
        }
    }
}