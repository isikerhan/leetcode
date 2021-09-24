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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = null;
        ListNode prev = null;
        int k = 0;
        
        while(l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + k;
            k = sum / 10;
            ListNode node = new ListNode(sum % 10);
            if (prev != null)
                prev.next = node;
            if (head == null)
                head = node;
            prev = node;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next: null;
        }
        
        if (k > 0) {
            prev.next = new ListNode(k);
        }
        
        return head;
        
    }
}