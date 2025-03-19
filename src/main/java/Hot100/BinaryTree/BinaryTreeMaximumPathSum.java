package Hot100.BinaryTree;

public class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftScore = dfs(root.left);
        int rightScore = dfs(root.right);
        int maxScore = Math.max(leftScore, rightScore) + root.val;
        maxScore = Math.max(maxScore, root.val);
        maxSum = Math.max(maxSum, maxScore);
        maxSum = Math.max(maxSum, leftScore + rightScore + root.val);
        return maxScore;
    }
}
