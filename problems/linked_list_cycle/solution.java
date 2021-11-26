/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (set.contains(node.hashCode()))
                return true;
            set.add(node.hashCode());
            node = node.next;
        }
        return false;
    }
}