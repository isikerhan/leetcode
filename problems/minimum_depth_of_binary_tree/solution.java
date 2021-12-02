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
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        return minDepth(root, 1);
    }
    
    public int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null)
            return depth;
        return Math.min(root.left != null ? minDepth(root.left, depth + 1) : Integer.MAX_VALUE,
           root.right != null ? minDepth(root.right, depth + 1) : Integer.MAX_VALUE);
    }
}