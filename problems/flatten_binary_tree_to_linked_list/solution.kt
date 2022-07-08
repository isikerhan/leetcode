/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var prev: TreeNode? = null;

    fun flatten(node: TreeNode?): Unit {
        if (node == null)
            return

        prev?.left = null
        prev?.right = node
        prev = node

        val left = node.left
        val right = node.right
        flatten(left)
        flatten(right)
    }
}