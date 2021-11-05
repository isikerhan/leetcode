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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traverse(result, root, 0);
        return result;
    }
    
    public void traverse(List<List<Integer>> result, TreeNode node, int currLevel) {
        if (node == null)
            return;
        if (result.size() < currLevel + 1)
            result.add(new ArrayList<>());
        
        if (currLevel % 2 == 0)
            result.get(currLevel).add(node.val);
        else result.get(currLevel).add(0, node.val);
        
        traverse(result, node.left, currLevel + 1);
        traverse(result, node.right, currLevel + 1);
    }
}