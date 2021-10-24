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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null) {
            ListNode next = current.next;
            while (next != null && next.val == current.val)
                next = next.next;
            current.next = next;
            current = next;
        }
        return head;
    }
}