package GaoQi.Collection.Map.HashMap;

public class MyHashMapException<K, V> {
    NodeException[] table;
    int size;

    public MyHashMapException() {
        table = new NodeException[16];
    }


    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        // 计算hash值
        int hash = myHash(key.hashCode(), table.length);
        // 创建新节点
        NodeException newNode = new NodeException(key, value, hash);

        // 如果该位置为空，直接插入
        if (table[hash] == null) {
            table[hash] = newNode;
            size++;
            return;
        }

        // 遍历链表
        NodeException current = table[hash];
        while (current != null) {
            // 如果key已存在，更新value
            if (current.key.equals(key)) {
                current.value = value;
                return;
            }
            // 到达链表末尾
            if (current.next == null) {
                current.next = newNode;
                return;
            }
            current = current.next;
            size++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");

        for(int i=0;i<table.length;i++){
            NodeException current=table[i];
            while(current!=null){
                sb.append(current.key+"="+current.value+",");
                current=current.next;
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public V get(K key) {
        int hash=myHash(key.hashCode(), table.length);
        V value=null;

        if(table[hash]!=null){
            NodeException current=table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    value=(V)current.value;
                    break;
                }else{
                    current = current.next;
                }
            }
        }
        return value;
    }

    public static int myHash(int v,int length){
//        System.out.println("hash in MyHashMap"+(v&(length-1)));
//        System.out.println("hash in MyHashMap"+(v%(length-1)));
        return v&(length-1);
    }



    public static void main(String[] args) {
        MyHashMapException <Integer,String>map=new MyHashMapException<>();
        map.put(10,"a");
        map.put(20,"b");

        System.out.println(map.get(20));
        System.out.println(map.get(53));

    }



}




