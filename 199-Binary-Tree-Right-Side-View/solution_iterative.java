/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        //bfs
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            // traverse each level and add the most right node to res
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                
                if (i == 0)
                    res.add(node.val);
                    
                if (node.right != null)
                    q.add(node.right);
                if (node.left != null)
                    q.add(node.left);
            }
        }
        return res;
    }
}