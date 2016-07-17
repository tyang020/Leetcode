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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode root = new TreeNode(0);
        helper(root, nums, 0, nums.length - 1);
        return root;
    }
    public void helper (TreeNode root, int[] nums, int start, int end) {
        if (start > end) return;
        int mid = start + (end - start) / 2;
        root.val = nums[mid];
        
        helper(root.left, nums, start, mid - 1);
        helper(root.right, nums, mid+1, end);
    }
}