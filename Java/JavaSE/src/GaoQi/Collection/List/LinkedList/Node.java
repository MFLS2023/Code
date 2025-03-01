package GaoQi.Collection.List.LinkedList;

public class Node {

    Node prev;
    Node next;
    Object data;

    public Node(Node prev, Node next, Object data) {
        this.prev = prev;
        this.next = next;
        this.data = data;
    }
}
