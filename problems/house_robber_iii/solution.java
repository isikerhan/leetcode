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
    
    Map<TreeNode, Integer> dp = new HashMap<>();
    
    public int rob(TreeNode root) {
        
        if (root == null)
            return 0;
        
        if (dp.containsKey(root))
            return dp.get(root);
        
        int robbed = root.val +
            (root.left != null ? rob(root.left.left) + rob(root.left.right) : 0) +
            (root.right != null ? rob(root.right.left) + rob(root.right.right) : 0);
        int notRobbed = rob(root.left) + rob(root.right);
        
        int result = Math.max(robbed, notRobbed);
        dp.put(root, result);
        return result;
    }
}