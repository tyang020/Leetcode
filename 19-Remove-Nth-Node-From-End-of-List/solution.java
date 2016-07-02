/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0), p = head;
        dummy.next = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int i = -1;
        p = dummy;
        //find the nth node form the end
        while (len - n - 1 != i++) {
            p = p.next;
        }
        //remove that node
        p.next = p.next.next;
        return dummy.next;
    }
}