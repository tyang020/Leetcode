/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy; // insert node between p and p.next;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            // find the right place to insert the value
            while (p.next != null && p.next.val < cur.val) {
                p = p.next;
            }
            
            // Insert the value
            cur.next = p.next; // when p.next == null, insert cur to the last node, else insert it between p and p.next;
            p.next = cur;
            
            // continue to next node and set p to dummy;
            cur = next; 
            p = dummy;
        }
        return dummy.next;
    }
}