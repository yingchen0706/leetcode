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
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        findPath(root, p, pList);
        findPath(root, q, qList);
        int i = pList.size() -1, j = qList.size() - 1;
        while (i >=0 && j >=0) {
            if (pList.get(i).val != qList.get(j).val) {
                break;
            }
            i--;
            j--;
        }
        return pList.get(i+1);
    }
    
    private boolean findPath(TreeNode root, TreeNode p, List<TreeNode> list) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            list.add(root);
            return true;
        } 
        if (findPath(root.left, p, list)) {
            list.add(root);
            return true;
        } else if (findPath(root.right, p, list)) {
            list.add(root);
            return true;
        }
        return false;
    }
}
