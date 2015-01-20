public class Solution {
  /**
   * the depth of a node must reaches leaf: 
   *    if a node has only one child, need to go through the other path util leaf to find depth
   * 
   *    depth of node: NODEs from node to leaf. [gerneral depth is defined as edges. see question describetion]
   */
  public int minDepth(TreeNode root) {
    if (root==null) return 0;
    if (root.left==null && root.right!=null)  return 1+minDepth(root.right);
    if (root.right==null && root.left!=null)  return 1+minDepth(root.left);
    return 1+Math.min(minDepth(root.right),minDepth(root.left));
  }
}
