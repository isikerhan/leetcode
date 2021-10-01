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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];
        
        int k = lists.length;
        ListNode head = null;
        ListNode curr = null;
        
        // an ugly optimization, not optimizing much
        boolean search = true;
        int prev = -1;
        
        while(true) {
            int minIndex = -1;
            int minVal = Integer.MAX_VALUE;
            
            if (search) {
                for (int i = 0; i < k; i++) {
                    if (lists[i] != null && minVal >= lists[i].val) {
                        minVal = lists[i].val;
                        minIndex = i;
                    }
                }
                if (minIndex < 0)
                    break;
            } else {
                minIndex = prev;
            }

            ListNode node = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            search = lists[minIndex] == null || lists[minIndex].val != minVal;
            if (curr != null) {
                curr.next = node;
            } else {
                head = node;
            }
            curr = node;
            prev = minIndex;
        }
        return head;
    }
}