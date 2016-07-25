/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while(level_start != null && level_start.left != null) {
            //record the first node of each level
            TreeLinkNode cur = level_start;
            while(cur.left != null) {
                cur.left.next = cur.right;
                if (cur.next != null)
                    cur.right = cur.next.left;
                cur = cur.next;
            }
            
            level_start = level_start.left;
        }
    }
}