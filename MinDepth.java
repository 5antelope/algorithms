public class Solution {
  public int minDepth(TreeNode root) {
    if (root==null) return 0;
    return 1+Math.min(minDepth(root.right),minDepth(root.left));
  }
}
