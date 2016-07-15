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
    public int kthSmallest(TreeNode root, int k) {
        int count = countNode(root.left);
        if (count >= k) 
            return kthSmallest(root.left, k);
        else if (count == k - 1) 
            return root.val;
        else
            return kthSmallest(root.right, k - 1 - count);
    }
    private int countNode(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNode(node.left) + countNode(node.right);
    }
}