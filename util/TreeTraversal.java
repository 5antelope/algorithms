/**
 * http://datastructuresnotes.blogspot.com/2009/02/binary-tree-traversal-preorder-inorder.html
 * 
 * both pre/post order:
 *    stack.push(root)
 *    cur = null
 * 
 * only in order:
 *    cur = root
 */

public void preorder(TreeNode root) {
  TreeNode cur = null;
  LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
  s.push(root);
  /** root - left - right. 
   * stack pop first, then right - left
  */
  while (!s.isEmpty()) {  // "弹-右-左"
    cur = s.pop();  
    System.out.println(cur.val);
    if (cur.right!=null) s.push(cur.right);
    if (cur.left!=null)  s.push(cur.left);
  }
}

public void inorder(TreeNode root) {
  List<Integer> res = new ArrayList<Integer>();
        
  if (root==null)
      return res;
  
  TreeNode pre = null, cur = null;
  
  LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
  stack.push(root);
  
  while (!stack.isEmpty()) {
      
      cur = stack.peek();
      
      // only cases to print element:
      // 1. leaf (left==null & right=null)
      // 2. post-order (i.e., children have been visited): 
      //      cur.left == prev || cur.right == prev
      if ( cur.left==null && cur.right==null
          || cur.left == pre && pre!=null 
          || cur.right == pre && pre!=null ) {
          pre = cur;
          res.add(stack.pop().val);
      }
      else {
          if (cur.right!=null)
              stack.push(cur.right);
          if (cur.left!=null)
              stack.push(cur.left);
      }
  }
  
  return res;
}
