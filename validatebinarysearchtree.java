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
        if (root == null) {
            return true;
        }
        if ((min !=null && root.val <= min) || (max != null && root.val >=max)) {
            return false;
        }
        return isValidSubBST(root.left, min, root.val) && isValidSubBST(root.right, root.val, max);

    }
}
