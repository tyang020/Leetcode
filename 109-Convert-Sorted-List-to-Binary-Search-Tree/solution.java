/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return helper(head, count(head));
    }
    //Count the number of nodes
    private int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }
    
    //Convert List to BST
    private TreeNode helper(ListNode head, int n) {
        if (n < 0 || head == null) return null;
        int i = 0;
        ListNode p = head;
        while (i < n / 2) {
            p = p.next;
            i++;
        }
        TreeNode node = new TreeNode(p.val);
        node.left = helper(head, n/2);
        node.right = helper(p.next, n - n/2 - 1);
        return node;
    }
}