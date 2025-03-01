package GaoQi.Collection.Map.HashMap;

public  class Node {
    Object key;
    Object value;
    int hash;
    Node next;

    Node(Object key, Object value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }
}

