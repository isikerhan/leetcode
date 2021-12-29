/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Left *Node
 *     Right *Node
 *     Next *Node
 * }
 */

func connect(root *Node) *Node {
    if root == nil {
        return nil
    }
	queue := []*Node{root}

	for len(queue) > 0 {
		size := len(queue)
		var prev *Node

		for i := 0; i < size; i++ {
			current := queue[0]
			queue = queue[1:]

			if current.Left != nil {
				queue = append(queue, current.Left)
			}
			if current.Right != nil {
				queue = append(queue, current.Right)
			}

			if prev != nil {
				prev.Next = current
			}
			prev = current
		}
	}

	return root
}