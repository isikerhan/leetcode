/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var head *ListNode
	var curr *ListNode

	carry := 0
	for l1 != nil || l2 != nil {
		var val1 int
		var val2 int
		if l1 != nil {
			val1 = l1.Val
		} else {
			val1 = 0
		}
		if l2 != nil {
			val2 = l2.Val
		} else {
			val2 = 0
		}
		sum := val1 + val2 + carry
		carry = sum / 10
		newNode := &ListNode{Val: sum % 10}

		if curr != nil {
			curr.Next = newNode
		} else {
			head = newNode
		}
		curr = newNode
		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}
	}

	if carry > 0 {
		curr.Next = &ListNode{Val: carry}
	}

	return head
}
