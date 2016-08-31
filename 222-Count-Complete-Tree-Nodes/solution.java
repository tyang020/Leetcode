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
    public int countNodes(TreeNode root) {
        TreeNode p = root;
        int h = height(root), count = 0;
        while (p != null) {
            if (height(p.right) == h - 1) {
                count += 1 << h;   // the number of nodes of left tree plus one root
                p = p.right;
            } else {
                count += 1 << (h-1); //# of node in right tree plus one root
                p = p.left;
            }
            h--;
        }
        return count;
    }
    
    private int height(TreeNode root) {
        int h = -1;
        TreeNode p = root;
        while (p != null) {
            h++;
            p = p.left;
        }
        return h;
    }
}