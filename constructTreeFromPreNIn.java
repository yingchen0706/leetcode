/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecur(preorder, inorder, 0, 0, inorder.length);
    }
    
    public TreeNode buildTreeRecur(int[] preorder, int[] inorder, int preStart, int inStart, int length) {
        if (length <=0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootInOrder = 0;
        for (int i = inStart; i < inStart + length; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootInOrder = i;
            }
        }
        int lenL = rootInOrder - inStart;
        int lenR = inStart + length - rootInOrder-1;
        root.left = buildTreeRecur(preorder, inorder, preStart+1, rootInOrder - lenL, lenL);
        root.right = buildTreeRecur(preorder, inorder, preStart + lenL+1 , rootInOrder+1, lenR);
        return root;
    }
}
