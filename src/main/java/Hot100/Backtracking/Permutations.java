package Hot100.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    List<List<Integer>> ans;
    List<Integer> path;
    boolean[] visited;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        path = new ArrayList<>();
        int n = nums.length;
        visited = new boolean[n];
        dfs(nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int cur) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, cur + 1);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
