package Hot100.BinaryTree;

public class KthSmallestElementInaBST {
    int index = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        index++;
        if (index == k) {
            ans = root.val;
            return;
        }
        inorder(root.right, k);
    }
}
