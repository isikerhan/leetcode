/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxAncestorDiff(root *TreeNode) int {
	return maxDiff(root, root.Val, root.Val)
}

func maxDiff(node *TreeNode, min int, max int) int {
	if node == nil {
		return 0
	}

	diff := int(math.Max(math.Abs(float64(node.Val-min)), math.Abs(float64(max-node.Val))))

	if min > node.Val {
		min = node.Val
	}

	if max < node.Val {
		max = node.Val
	}

	return int(math.Max(float64(diff), math.Max(float64(maxDiff(node.Left, min, max)), float64(maxDiff(node.Right, min, max)))))
}