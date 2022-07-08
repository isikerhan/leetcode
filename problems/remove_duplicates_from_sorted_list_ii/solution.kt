/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var resultHead = head
        var node = head
        var prev: ListNode? = null
        while (node != null) {
            var next = node.next
            while (node.`val` == next?.`val`) {
                next = next.next
            }

            if (next != node.next) {
                prev?.next = next
                if (node == resultHead)
                    resultHead = next
            } else {
                prev = node
            }
            node = next
        }

        return resultHead
    }
}