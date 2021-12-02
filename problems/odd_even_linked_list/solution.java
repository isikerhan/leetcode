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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode oddHead = null, evenHead = null, odd = null, even = null, current = head;
        int i = 1;
        while (current != null) {
            if (i % 2 == 1) {
                if (odd != null) {
                    odd.next = current;
                } else {
                    oddHead = current;
                }
                odd = current;
            } else {
                if (even != null) {
                    even.next = current;
                } else {
                    evenHead = current;
                }
                even = current;
            }
            i++;
            current = current.next;
        }
        odd.next = evenHead;
        even.next = null;
        return oddHead;
    }
}

