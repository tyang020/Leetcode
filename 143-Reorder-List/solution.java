/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        // 1->2->3->4->5->6
        if (head == null || head.next == null)
            return;
            
        ListNode slow = head, fast = head;
        // find middle node and reverse nodes after middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        } //slow = 3
        
        // prev refer to the first node of reversed list
        ListNode prev = null, cur = slow.next;
        slow.next = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        slow = head;
        fast = prev;
        while (fast != null) {
            ListNode slow_next = slow.next, fast_next = fast.next;
            slow.next = fast;
            fast.next = slow_next;
            slow = slow_next;
            fast = fast_next;
        }
        
    }
}