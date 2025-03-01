package GaoQi.Collection.Map.HashMap;

public class HashMap<K, V> {
    private Node<K, V>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    // 节点类定义
    private static class Node<K, V> {
        K key;
        V value;
        int hash;
        Node<K, V> next;

        Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = null;
        }
    }

    @SuppressWarnings("unchecked")
    public HashMap() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int hash = myHash(key.hashCode(), table.length);
        Node<K, V> newNode = new Node<>(key, value, hash);

        if (table[hash] == null) {
            table[hash] = newNode;
            size++;
            return;
        }

        Node<K, V> current = table[hash];
        Node<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                current.value = value; // 更新值
                return;
            }
            prev = current;
            current = current.next;
        }

        prev.next = newNode; // 在链表末尾添加新节点
        size++;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int hash = myHash(key.hashCode(), table.length);
        Node<K, V> current = table[hash];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("{");
        boolean first = true;

        for (Node<K, V> node : table) {
            while (node != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(node.key).append("=").append(node.value);
                first = false;
                node = node.next;
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private static int myHash(int hash, int length) {
        return hash & (length - 1);
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<K, V>[] oldTable = table;
        table = new Node[table.length * 2];
        size = 0;

        // 重新插入所有元素
        for (Node<K, V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(10, "aa");
        map.put(20, "bb");
        map.put(30, "cc");

        System.out.println("Size: " + map.size());
        System.out.println("Map: " + map);
        System.out.println("Value for key 20: " + map.get(20));
        System.out.println("Value for key 53: " + map.get(53));
    }
}
