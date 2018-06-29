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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> sublist = new LinkedList<Integer>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.add(sublist);
                sublist = new LinkedList<>();
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            } else {
                sublist.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return res;
    }
}
