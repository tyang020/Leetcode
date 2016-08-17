/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) 
            return head;
        ListNode cur = head;
        int len = 1;
        while(cur.next != null) {
            cur = cur.next;
            len++;
        }
        if (k % len == 0)
            return head;
        cur.next = head;
        // find the position to seperate
        for (int i = 0; i < len - k % len; i++) {
            cur = cur.next;
        }
        
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}