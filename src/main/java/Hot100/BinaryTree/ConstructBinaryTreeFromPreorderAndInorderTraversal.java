package Hot100.BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        inorderMap = new HashMap<>();
        for (int i = 0 ; i < n ; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        int rootVal = preorder[preStart];
        int rootIndex = inorderMap.get(rootVal);
        int leftLen = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd){
            return root;
        }
        root.left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, rootIndex + 1, inEnd);
        return root;
    }
}
