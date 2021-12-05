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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, 0, new ArrayList<>(), result);
        return result;
    }
    
    public void pathSum(TreeNode node, int targetSum, int currSum, List<Integer> currPath, List<List<Integer>> paths) {
        if (node == null)
            return;
        currPath.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val + currSum == targetSum) {
                paths.add(new ArrayList<>(currPath));
            }
        } else {
            pathSum(node.left, targetSum, currSum + node.val, currPath, paths);
            pathSum(node.right, targetSum, currSum + node.val, currPath, paths);
        }
        currPath.remove(currPath.size() - 1);
    }
}