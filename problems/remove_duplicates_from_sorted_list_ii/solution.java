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
    public ListNode deleteDuplicates(ListNode head) {
		ListNode node = head;
		ListNode prev = null;
		while (node != null) {
			ListNode next = node.next;
			while (next != null && node.val == next.val) {
				next = next.next;
			}
			
			if (next != node.next) {
				if (prev != null) {
					prev.next = next;
				}
				if (node == head) {
					head = next;
				}
			} else {
				prev = node;
			}
			node = next;
		}
		return head;
	}
}