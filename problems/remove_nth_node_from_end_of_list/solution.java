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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        
        if (fast == null) {
            head = head.next;
            return head;
        }
        
        ListNode curr = head;
        while (fast.next != null) {
            curr = curr.next;
            fast = fast.next;
        }
        
        curr.next = curr.next.next;
        return head;
    }
}