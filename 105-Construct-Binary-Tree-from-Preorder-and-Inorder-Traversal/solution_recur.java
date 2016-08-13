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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length, 0);
    }
    
    /** The main idea is: the first value in preorder is root(pre_root), and next is root.left(pre_root+1). What we need to do is to find the position of root.right in preorder by using the inorder array.
     *  First, find the root value in inorder array in the index range of in_start to in_end and record the root index as in_root;
     *  Second, since all the values between in_start and in_root are on the left side of root, we get the number of nodes on the left side of root = in_root - in_start;
     *  Third, as for preorder, root.right is at the position after all the nodes in the left side of root. The index of root.right is pre_root+(in_root-in_start)+1;
     */
    private TreeNode helper(int[] preorder, int[] inorder, int in_start, int in_end, int pre_root) {
        if (in_start > in_end || pre_root >= preorder.length)
            return null;
        
        TreeNode root = new TreeNode(preorder[pre_root]);
        
        int in_root = 0;
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == preorder[pre_root]) {
                in_root = i;
                break;
            }
        }
        root.left = helper(preorder, inorder, in_start, in_end-1, pre_root+1);
        root.right = helper(preorder, inorder, in_start+1, in_end, pre_root+in_root-in_start+1);
        return root;
    }
}