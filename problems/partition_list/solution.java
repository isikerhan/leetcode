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
    public ListNode partition(ListNode head, int x) {
        
        ListNode firstHead = null, secondHead = null, 
            firstCurr = null, secondCurr = null, curr = head;
        
        while (curr != null) {
            if (curr.val < x) {
                if (firstCurr != null)
                    firstCurr.next = curr;
                else firstHead = curr;
                firstCurr = curr;
            } else {
                if (secondCurr != null)
                    secondCurr.next = curr;
                else secondHead = curr;
                secondCurr = curr;
            }
            
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        
        if (firstCurr != null)
            firstCurr.next = secondHead;
        else firstHead = secondHead;
        
        return firstHead;
    }
}