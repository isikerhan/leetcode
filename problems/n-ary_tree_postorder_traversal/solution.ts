/**
 * Definition for node.
 * class _Node {
 *     val: number
 *     children: _Node[]
 *     constructor(val?: number) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.children = []
 *     }
 * }
 */


function postorder(root: _Node | null): number[] {
  const postorderItems = Array<number>();
  traversePostorder(root, postorderItems);
  return postorderItems;
};

function traversePostorder(node: _Node | null, traversed: number[]) {
  if (node == null) {
    return;
  }

  node.children.forEach((child) => traversePostorder(child, traversed));
  traversed.push(node.val);
}
