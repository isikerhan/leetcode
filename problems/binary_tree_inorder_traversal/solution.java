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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        traverse(result, root);
        return result;
    }
    
    public void traverse(List<Integer> result, TreeNode node) {
        if (node == null)
            return;
        traverse(result, node.left);
        result.add(node.val);
        traverse(result, node.right);
    }
}