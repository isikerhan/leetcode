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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }
    
    public void traverse(List<List<Integer>> result, TreeNode node, int currentLevel) {
        if (node == null)
            return;
        if (result.size() < currentLevel + 1)
            result.add(new ArrayList<>());
        result.get(currentLevel).add(node.val);
        traverse(result, node.left, currentLevel + 1);
        traverse(result, node.right, currentLevel + 1);
    }
}