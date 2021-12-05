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
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, new ArrayList<>());
    }
    
    public int pathSum(TreeNode node, int targetSum, ArrayList<Integer> sums) {
        if (node == null)
            return 0;
        int result = 0;
        sums.add(0);
        for (int i = 0; i < sums.size(); i++) {
            int sum = sums.get(i) + node.val;
            sums.set(i, sum);
            if (sum == targetSum)
                result++;
        }
        result += pathSum(node.left, targetSum, sums);
        result += pathSum(node.right, targetSum, sums);
        sums.remove(sums.size() - 1);
        for (int i = 0; i < sums.size(); i++) {
            int sum = sums.get(i) - node.val;
            sums.set(i, sum);
        }
        
        return result;
    }
}