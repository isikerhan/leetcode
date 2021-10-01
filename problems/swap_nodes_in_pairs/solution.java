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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode first = head, prev = null;
        ListNode myHead = first.next;
        
        while(first != null) {
            ListNode second = first.next;
            ListNode next = second != null ? second.next : null;
            if (second == null) {
                prev.next = first;
            } else {
                second.next = first;
                if (prev != null)
                    prev.next = second;
                prev = first;
            }
            first.next = null;
            first = next;
        }
        return myHead;
    }
}