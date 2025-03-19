package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int n = nums.length;
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        //不选该数
        dfs(nums, cur + 1);
        //选该数
        path.add(nums[cur]);
        dfs(nums, cur + 1);
        path.remove(path.size() - 1);
    }
}
