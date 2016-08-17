/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        
        ListNode dummy = new ListNode(0), cur = dummy;
        dummy.next = head;
        while (cur != null && cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                ListNode dup = cur.next.next;
                
                while (dup.next != null && dup.next.val == val)
                    dup = dup.next;
                
                cur.next = dup.next;
            } else
                cur = cur.next;
        }
        return dummy.next;
    }
}