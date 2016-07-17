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
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }
    /** We use an array to save the max money we can get when root is robbed and not robbed */
    public int[] robSub(TreeNode root) {
        if (root == null)
            return new int[2];
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1]; //rob root, not rob left or right
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //not rob root, then rob max of sum of left and right;
        return res;
    }
}