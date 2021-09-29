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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        ListNode head = null;
        ListNode prev = null;
        
        while(l1 != null || l2 != null) {
            ListNode curr;
            if (l1 == null) {
                curr = l2;
                l2 = l2.next;
            } else if(l2 == null) {
                curr = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                curr = l1;
                l1 = l1.next;
            } else {
                curr = l2;
                l2 = l2.next;
            }
            
            if (prev == null) {
                head = curr;
            } else {
                prev.next = curr;
            }
            
            prev = curr;
        }
        
        return head;
    }
}