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
        /** DFS */
        List<List<Integer>> res = new ArrayList();
        dfs(res, root, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        
        /* if this level has no vals, add this level to res */
        if (res.size() <= level) {
            res.add(new ArrayList<Integer>());
        }
        
        List<Integer> curLevel = res.get(level);
        if (level % 2 != 0)
            curLevel.add(0, root.val);
        else
            curLevel.add(root.val);
        
        dfs(res, root.left, level + 1);
        dfs(res, root.right, level + 1);
    }
}