package Hot100.BinaryTree;

public class LowestCommonAncestorOfABinaryTree {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = new TreeNode();
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || ((root == p || root == q) && (lson || rson))){
            ans = root;
        }
        return lson || rson || (root == p || root == q);
    }
}
