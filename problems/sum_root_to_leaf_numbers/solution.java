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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    
    public int sumNumbers(TreeNode node, int currentValue) {
        currentValue = currentValue * 10 + node.val;
        if (node.left == null && node.right == null)
            return currentValue;
        return (node.left == null ? 0 : sumNumbers(node.left, currentValue)) +
            (node.right == null ? 0 : sumNumbers(node.right, currentValue));
    }
}