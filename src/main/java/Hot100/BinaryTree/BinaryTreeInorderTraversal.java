package Hot100.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    private List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new ArrayList<>();
        inorderRecursively(root);
        return ans;
    }
    public void inorderRecursively(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderRecursively(root.left);
        ans.add(root.val);
        inorderRecursively(root.right);
    }
}