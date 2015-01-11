public class Stack {
    LinkedList<Node> stack;
    Stack() {
        stack = new LinkedList<Node>();
    }
    public Node peek() {
        if (stack.size() == 0)
            return null;
        else {
            // use peekFirst() to simulate Stack, not peekLast()!
            return stack.peekFirst();
        }
    }
    public Node pop () {
        if (stack.size() == 0)
            return null;
        else {
            return stack.pop();
        }
    }
    public void push (Node n) {
        stack.push(n);
    }
}
