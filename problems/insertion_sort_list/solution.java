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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode current = head.next;
        ListNode prev = head;
        while (current != null) {
            ListNode next = current.next;
            
            if (prev.val > current.val) {
                prev.next = next;
                head = insert(head, current, prev);
            } else {
                prev = current;
            }
            current = next;
        }
        return head;
    }
    
    private ListNode insert(ListNode head, ListNode item, ListNode tail) {
        if (item.val < head.val) {
            item.next = head;
            return item;
        }
        
        ListNode prev = head, current = head.next;
        
        while (item.val > current.val) {
            prev = current;
            current = current.next;
        }
        
        prev.next = item;
        item.next = current;
        
        return head;
    }
}