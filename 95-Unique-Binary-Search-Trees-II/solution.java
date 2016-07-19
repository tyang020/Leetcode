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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return bstHelper(1, n);
    }
    
    private List<TreeNode> bstHelper(int start, int end) {
        List<TreeNode> list = new ArrayList();
        if (start > end)
            list.add(null);
            
            
        for (int i = start; i <= end; i++) {
            /** Each BST consists of a root with value r and its left nodes with all vals less than r(1 to r-1) and 
             *  right nodes with all vals larger than r (r+1 to n)
             */
            
            List<TreeNode> left = bstHelper(start, i - 1);
            List<TreeNode> right = bstHelper(i + 1, end);
            for (TreeNode lnode : left) {
                for (TreeNode lright : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = lright;
                    list.add(root);
                }
            }
        }
        
        return list;
    }
}