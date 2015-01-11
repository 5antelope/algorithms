public class Queue_LL {
    LinkedList<Node> queue = new LinkedList<Node>();
    public void enqueue(Node n) {
        queue.push(n);
    }
    /*
        linkedlist input: 1 - 3 - 7;
        allocation : {7, 3, 1}, stack-like order
        therefore, wanna get 1 : take getLast()
    */
    public Node dequeue() {
        Node n = queue.getLast();       // getLast() HERE!
        queue.remove(queue.size()-1);   // manually remove!
        return n;
    }
}
