package GaoQi.Collection.Map.HashMap;

public class NodeException <K,V>{
    int hash;
    K key;
    V value;
    NodeException next;

    NodeException(K key, V value, int hash) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }
}
