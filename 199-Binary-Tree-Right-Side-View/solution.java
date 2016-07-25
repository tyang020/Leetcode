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
    public List<Integer> rightSideView(TreeNode root) {
        
    }
    
    private void rightView(TreeNode cur, List<Integr> res, int depth) {
        if (cur == null) 
            return;
        if (res.size() == depth)
            res.add(cur.val);
        rightView(cur.right, res, depth + 1);
        rightView(cur.left, res, depth + 1);
    }
}