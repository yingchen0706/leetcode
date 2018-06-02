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
        StringBuilder res=new StringBuilder("");
        
        if (root == null) {
            return res.toString();
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.add(root);
        
        while(q.size() > 0) {
            TreeNode curNode = q.remove();
            if (curNode != null) {
                res.append("\\" + curNode.val);
                q.add(curNode.left);
                q.add(curNode.right);
            } else {
                res.append("\\#");
            }            
        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root=null;
        if (data.equals("")) {
            return root;
        }
        String[] dataList = data.split("\\\\");
         root = new TreeNode(Integer.parseInt(dataList[1]));
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        for (int i = 2; i < dataList.length; i+=2) {
            String left = dataList[i];
            String right = dataList[i+1];
            TreeNode node = q.remove();
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                q.add(node.left);
            }
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                q.add(node.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
