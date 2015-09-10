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
    /* visualization of case: 
     *   x
     *    \  
     *     y
     */
    }
  }
}

public void postorder(TreeNode root) {
  if(root == null)
      return; 

  Stack<TreeNode> stack = new Stack<TreeNode>();
  stack.push(root);

  TreeNode prev = null;
  while(!stack.empty()){
      TreeNode curr = stack.peek();

      // go down the tree.
      //check if current node is leaf, if so, process it and pop stack,
      //otherwise, keep going down
      if(prev == null || prev.left == curr || prev.right == curr){
          //prev == null is the situation for the root node
          if(curr.left != null){
              stack.push(curr.left);
          }else if(curr.right != null){
              stack.push(curr.right);
          }else{
              stack.pop();
              System.out.println(curr.val);
          }

      //go up the tree from left node    
      //need to check if there is a right child
      //if yes, push it to stack
      //otherwise, process parent and pop stack
      }else if(curr.left == prev){
          if(curr.right != null){
              stack.push(curr.right);
          }else{
              stack.pop();
              System.out.println(curr.val);
          }

      //go up the tree from right node 
      //after coming back from right node, process parent node and pop stack. 
      }else if(curr.right == prev){
          stack.pop();
          System.out.println(curr.val);
      }

      prev = curr;
  }
}
