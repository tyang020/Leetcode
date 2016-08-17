/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m == n)
            return head;
        ListNode prev = null, dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        for (int i = 0; i < m-1; i++) {
            cur = cur.next;
        }
        
        ListNode start = cur;
        cur = cur.next;
        ListNode end = cur;
        
        for (int i = m; i < n; i++) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        
        end.next = cur.next;
        cur.next = prev;
        start.next = cur;
        
        return dummy.next;
    }
}