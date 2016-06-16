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
        searchDfs(root, res, 0);
        return res;
    }
    public static void searchDfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;
        if (res.size() <= level)
            res.add(0, new ArrayList<>());
        res.get(res.size()-level-1).add(root.val);
        searchDfs(root.left, res, level + 1);
        searchDfs(root.right, res, level + 1);
    }
}