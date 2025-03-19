package Hot100.BinaryTree;

public class PathSumIII {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int ans = dfs(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    public int dfs(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == targetSum) {
            res++;
        }
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }
}
