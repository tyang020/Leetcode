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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i],i);
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1, map);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int in_start, int in_end, int post_root, Map<Integer, Integer> map) {
        if (in_start > in_end || post_root < 0)
            return null;
        
        TreeNode root = new TreeNode(postorder[post_root]);
        int in_root = map.get(postorder[post_root]);
        
        root.right = helper(inorder, postorder, in_root+1, in_end, post_root-1, map);
        root.left = helper(inorder, postorder, in_start, in_root-1, post_root-(in_end-in_root)-1, map);
        return root;
    }
}