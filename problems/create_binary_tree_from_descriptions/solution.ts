/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

function createBinaryTree(descriptions: number[][]): TreeNode | null {
  const table = new Map<number, TreeNode>();
  const parents = new Set<number>();
  const children = new Set<number>();

  for (const description of descriptions) {
    const parent = description[0];
    const child = description[1];
    const isLeft = Boolean(description[2]);

    const parentNode = table.get(parent) ?? new TreeNode(parent, null, null);
    const childNode = table.get(child) ?? new TreeNode(child, null, null);

    table.set(parent, parentNode);
    table.set(child, childNode);

    if (isLeft) {
      parentNode.left = childNode;
    } else {
      parentNode.right = childNode;
    }

    parents.add(parent);
    children.add(child);
  }

  for (const child of children) {
    parents.delete(child);
  }

  return table.get([...parents.values()][0]) ?? null;
};