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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = count(head);
        int partSize = count / k;
        int largerParts = count - partSize * k;
        
        ListNode[] parts = new ListNode[k];
        ListNode current = head;
        for (int i = 0; i < k && current != null; i++) {
            int size = partSize;
            if (largerParts > 0) {
                size++;
                largerParts--;
            }
            parts[i] = current;
            
            for (int j = 0; j < size - 1; j++) {
                current = current.next;
            }
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }
        return parts;
    }
    
    private int count(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}