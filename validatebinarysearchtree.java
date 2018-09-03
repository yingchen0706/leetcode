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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }  
        
        return isValidSubBST(root, null, null);
    }
    
    private boolean isValidSubBST(TreeNode root, Integer min, Integer max) {
        if ((min !=null && root.val <= min) || (max != null && root.val >=max)) {
            return false;
        }
        boolean left = (root.left == null) || isValidSubBST(root.left, min, root.val);
        boolean right = (root.right == null) || isValidSubBST(root.right, root.val, max);
        return left && right;
    }
}
