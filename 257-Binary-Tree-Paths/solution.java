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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(res, root, new String());
        return res;
    }
    public static void dfs(List<String> res, TreeNode node, String str) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            res.add(str+node.val);
            return;
        }
        dfs(res,node.left,str+node.val+"->");
        dfs(res,node.right,str+node.val+"->");
    }
}