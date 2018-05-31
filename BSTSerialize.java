/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res="";
        
        if (root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        
        while(q.size() > 0) {
            TreeNode curNode = q.remove();
            res += "\\" + curNode.val;
            if (curNode.left!=null) {
                q.add(curNode.left);
            }
            if (curNode.right!=null) {
                q.add(curNode.right);
            }
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root=null;
        if (data.equals("")) {
            return root;
        }
        String[] dataList = data.split("\\\\");
        for (int i = 1; i < dataList.length; i++) {
           String elem = dataList[i];
           if (root == null) {
               root = new TreeNode(Integer.parseInt(elem));
           } else {
               insertNode(root, Integer.parseInt(elem));
           }
        }
        return root;
    }
    
    private void insertNode(TreeNode root, int val) {
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
                return;
            } else {
                insertNode(root.left, val);
            } 
        } else if (val > root.val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
                return;
            } else {
                insertNode(root.right, val);
            } 
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
