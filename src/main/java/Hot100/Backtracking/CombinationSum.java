package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> ans;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        dfs(candidates, target, 0, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, int cur, int sum) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target || cur >= candidates.length) {
            return;
        }

        //不选当前数字
        dfs(candidates, target, cur + 1, sum);

        //选当前数字
        path.add(candidates[cur]);
        dfs(candidates, target, cur, sum + candidates[cur]);
        path.remove(path.size() - 1);
    }
}
