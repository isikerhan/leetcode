/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode>[] paths = new List[2];
        getPaths(root, p, q, (List<TreeNode>[]) paths, new ArrayList<>());
        
        int i = 0;
        List<TreeNode> pPath = (List<TreeNode>) paths[0];
        List<TreeNode> qPath = (List<TreeNode>) paths[1];
        while (i < pPath.size() && i < qPath.size() && pPath.get(i) == qPath.get(i))
            i++;
        return pPath.get(i - 1);
    }
    
    public void getPaths(TreeNode node, TreeNode p, TreeNode q, List<TreeNode>[] paths, List<TreeNode> currPath) {
        if (node == null)
            return;
        currPath.add(node);
        if (node == p)
            paths[0] = new ArrayList<>(currPath);
        else if (node == q)
            paths[1] = new ArrayList<>(currPath);
        
        if (paths[0] != null && paths[1] != null)
            return;
        
        getPaths(node.left, p, q, paths, currPath);
        getPaths(node.right, p, q, paths, currPath);
        currPath.remove(currPath.size() - 1);
    }
}