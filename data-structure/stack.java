Class Node {
  int val;
  Node next;
  Node (int val) {
    this.val = val;
    this.next = null;
  }
}
// use linked list for stack / queue
Class Stack {
  Node top;
  public Stack(Node n) {
    top = n;
  }
  public Node peek () {
    Node p = top;
    top = p.next;
    return p;
  }
  public Node pop () {
    Node p = top;
    top = p.next;
    return p;
  }
  public void push(Node node) {
    node.next = top;
    top = node;
  }
}
