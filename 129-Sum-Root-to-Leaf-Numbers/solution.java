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
    public int sumNumbers(TreeNode root) {
        // Recursive method:
        return dfsHelper(root, 0);
    }
    public int dfsHelper(TreeNode root, int parentSum) {
        // Return the calculated sum to its parent
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return parentSum*10 + root.val;

        // Pass the sum to its children until they return their calculated sum
        return dfsHelper(root.left, parentSum*10 + root.val) + dfsHelper(root.right, parentSum*10 + root.val);
    }
}