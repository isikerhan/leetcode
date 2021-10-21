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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        
        int count = count(head);
        int shift = k % count;
        
        if(shift == 0)
            return head;
        
        ListNode first = head;
        ListNode last = first;
        while (shift > 0) {
            last = last.next;
            shift--;
        }
        
        while (last.next != null) {
            first = first.next;
            last = last.next;
        }
        
        ListNode newHead = first.next;
        first.next = null;
        last.next = head;
        return newHead;
    }
    
    public int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}