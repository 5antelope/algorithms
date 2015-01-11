public class Queue_LL {
    LinkedList<Node> queue = new LinkedList<Node>();
    public void enqueue(Node n) {
        queue.push(n);
    }
    public Node dequeue() {
        Node n = queue.getLast();       // getLast() HERE!
        queue.remove(queue.size()-1);   // manually remove!
        return n;
    }
}
