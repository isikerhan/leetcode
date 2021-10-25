/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }
    
    public int maxDepth(TreeNode node, int currentDepth) {
        if (node == null)
            return currentDepth - 1;
        return Math.max(maxDepth(node.left, currentDepth + 1), maxDepth(node.right, currentDepth + 1));
    }
}