package Hot100.BinaryTree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (    (t1.val == t2.val) &&
                (isMirror(t1.left, t2.right)) &&
                (isMirror(t1.right, t2.left))){
            return true;
        }
        return false;
    }
}
