Class Node {
  int val;
  Node next;
  Node (int val) {
    this.val = val;
    this.next = null;
  }
}
/* use linked list for stack / queue
  in Java, LinkedList implementes 'queue' interface
  */
Class Stack {
  Node top;
  public Node peek () {
    if (top == null) {
      return null;
    }
    else 
      // peek does not modify stack, only return
      return top;
  }
  public Node pop () {
    if (top == null) {
      return null;
    }
    else {
      Node p = top;
      top = p.next;
      return p;
    }
  }
  public void push(Node node) {
    node.next = top;
    top = node;
  }
}
