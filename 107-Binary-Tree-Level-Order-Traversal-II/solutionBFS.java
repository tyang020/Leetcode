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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                root = q.poll();
                if (root != null) {
                    curLevel.add(root.val);
                }
                if (root.left != null) 
                    q.add(root.left);
                if (root.right != null)
                    q.add(root.right);
            }
            res.add(0,curLevel);
        }
        return res;
    }
}