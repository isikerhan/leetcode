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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode node = head;
        ListNode fast = head.next;
        
        while (fast.next != null) {
            node = node.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }
        
        node = node.next;
        Stack<ListNode> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
                
        node = head;
        while (!stack.isEmpty()) {
            ListNode next = node.next;
            node.next = stack.pop();
            node.next.next = next;
            node = next;
        }
        node.next = null;
    }
}