/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if (k == 1)
            return head;
        
        ListNode start = head, end = head;
        for (int i = 0; i < k -1; i++) {
            end = end.next;
        }
        
        ListNode prev = null;
        while (end != null) {
            ListNode currStart = start;
            ListNode currEnd = end;
            if (prev == null) {
                head = end;
            } else {
                prev.next = end;
            }
            prev = start;
            for (int i = 0; end != null && i < k; i++) {
                start = start.next;
                end = end.next;
            }
            reverse(currStart, currEnd);
        }
        return head;
    }
    
    public void reverse(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode endNext = end.next;
        
        while(curr != endNext) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        start.next = endNext;
    }
}