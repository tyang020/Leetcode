/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0); //need to keep track of the head of left and right
        ListNode left = dummy1, right = dummy2; // left runner and right runner
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }
            head = head.next;
        }
        // add head of right to tail of left;
        right.next = null;
        left.next = dummy2.next;
        return dummy1.next;
    }
}