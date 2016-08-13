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
        if (inorder.length == 0)
            return null;
        
        int in_idx = inorder.length-1, post_idx = postorder.length-2;
        TreeNode root = new TreeNode(postorder[post_idx+1]), top = null;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        while(in_idx >= 0) {
            if (!stack.isEmpty() && stack.peek().val == inorder[in_idx]) {
                top = stack.pop();
                in_idx--;
            } else {
                TreeNode cur_node = new TreeNode(postorder[post_idx]);
                if (top != null) {
                    top.left = cur_node;
                    top = null;
                } else
                    stack.peek().right = cur_node;
                
                stack.push(cur_node);
                post_idx--;
            }
        }
        return root;
    }
}