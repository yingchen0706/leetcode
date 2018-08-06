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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode oneNodeInLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode oneNodeInRight = lowestCommonAncestor(root.right, p, q);
        return oneNodeInLeft == null ? oneNodeInRight : (oneNodeInRight == null ? oneNodeInLeft : root);
    }
}
