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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left == null && root.right == null){
            if(root.val == sum) {
                List<Integer> l = new ArrayList<>();
                l.add(root.val);
                res.add(l);
            }
            return res;
        }
        res.addAll(pathSum(root.left, sum - root.val));
        res.addAll(pathSum(root.right, sum - root.val));
        for (int i = 0; i < res.size(); i++) {
            res.get(i).add(0,root.val);
        }
        return res;
    }
}