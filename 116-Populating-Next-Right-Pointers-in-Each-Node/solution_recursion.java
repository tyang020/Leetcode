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
        if (root == null) return;
        //root.next = null;
        TreeLinkNode node = root;
        if (node.left != null && node.right != null) {
            node.left.next = node.right;
            if (node.next != null)
                node.right.next = node.next.left;
            else
                node.right.next = null;
            connect(node.left);
            connect(node.right);
        }
    }
}