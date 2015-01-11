public class Queue {
    Node head, tail; // need 2 pointers in queuue impl.
    public void enqueue (Node n) {
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
    }
    public Node dequeue() {
        if (head == null)
            return null;
        else {
            Node n = head;
            head = head.next;
            return n;
        }
    }
}
