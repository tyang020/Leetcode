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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /** BFS */
        List<List<Integer>> res = new ArrayList();
        if (root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean inorder = true;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (inorder)
                    curLevel.add(node.val);
                else
                    curLevel.add(0, node.val);
                
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            res.add(curLevel);
            inorder = inorder ? false : true;
        }
        return res;
    }
}