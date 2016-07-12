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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList();
        preTraversal(root, list);
        return list;
    }
    private void preTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preTraversal(root.left, list);
        preTraversal(root.right, list);
    }
}