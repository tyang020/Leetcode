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
    /** The main idea of iterative method is:
     *  1. Keep adding nodes in preorder to a stack, and construct the left node of each node until the top of the stack matches the node   in inorder, which means we already added all the left side node of current top node.
     *  2. Keep popping the top node in stack and moving forward in inorder at the same time until the top does not match the inorder node   and save the last matching node as prev_top;
     *  3. Add next node in preorder and add this node to prev_top.right. 
     *  4. Repeat 1,2,3
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        
        int in_idx = 0, pre_idx = 1;
        
        TreeNode top = null, root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        
        
        while (in_idx < inorder.length) {
            //2
            if (!stack.isEmpty() && stack.peek().val == inorder[in_idx]) {
                top = stack.pop();
                in_idx++;
            } else {
                TreeNode cur_node = new TreeNode(preorder[pre_idx]);
                
                if(top != null) {
                    top.right = cur_node;
                    top = null;
                } else
                    stack.peek().left = cur_node;
                
                stack.push(cur_node);
                pre_idx++;
            }
        }
        return root;
    }
}