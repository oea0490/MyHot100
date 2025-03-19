package Hot100.BinaryTree;

public class FlattenBinaryTreeToLinkedList {
    TreeNode preNode;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = preNode;
        preNode = root;
    }
}
