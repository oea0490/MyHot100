import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        String[] input = sc.nextLine().split(",");
        int[] nums = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        System.out.println(solution.findMatrix(nums));
    }
}

class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while (!map.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                int key = entry.getKey();
                int val = entry.getValue();
                temp.add(key);
                if (val == 1) iterator.remove();
                else map.put(key, val - 1);
            }
            ans.add(temp);
        }
        return ans;
    }
}