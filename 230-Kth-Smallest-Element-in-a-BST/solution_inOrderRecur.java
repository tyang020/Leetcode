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
    private static int count = 0;
    private static int res = 0;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrderRecu(root);
        return res;
    }
    public void inOrderRecu(TreeNode root) {
        if (root == null) return;
        if (root.left != null) inOrderRecu(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        inOrderRecu(root.right);
    }
}