public void preorder(TreeNode root) {
  TreeNode cur = null;
  LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
  s.push(root);
  /** root - left - right. 
   * stack pop first, then right - left
  */
  while (!s.isEmpty()) {  // "推-右-左"
    cur = s.pop();  
    System.out.println(cur.val);
    if (cur.right!=null) s.push(cur.right);
    if (cur.left!=null)  s.push(cur.left);
  }
}

public void inorder(TreeNode root) {
  LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
  /**
   * left - root - right
   * unlike preorder, cannot use cur.left / cur.right to track. 
   * otherwise might get into loop (go left vs. visit cur): deal only with cur!
  */
  TreeNode cur = root;
  while (!stack.isEmpty() || cur!=null) { // "左死-右死"
    if (cur!=null) {
      stack.push(cur);
      cur = cur.left;
    }
    else { // leaf node or only has right child
      cur = s.pop();
      System.out.println(cur.val);
      cur = cur.right;
    }
  }
}

public void postorder(TreeNode root) {
  LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
  TreeNode cur = null;
  stack.push(root);
  TreeNode pre = null;  // last pushed node
  while (!stack.isEmpty()) {
      cur = stack.peek();
      if (cur.left==null && cur.right==null || cur.left==pre || cur.right==pre) {
          pre = cur;
          System.out.println(stack.pop().val);
      }
      else {
          if (cur.right!=null)  stack.push(cur.right);
          if (cur.left!=null)  stack.push(cur.left);
      }
  }
}
