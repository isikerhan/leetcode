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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        ListNode before = left == 1 ? null : head;
        for (int i = 1; i < left - 1; i++) {
            before = before.next;
        }
        
        ListNode curr = before == null ? head : before.next;
        ListNode tail = curr;
        ListNode prev = null;
        ListNode next = null;
        
        for(int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        tail.next = next;
        if (before == null)
            head = prev;
        else before.next = prev;
        return head;
    }
}