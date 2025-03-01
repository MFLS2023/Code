package GaoQi.Collection.Map.HashMap;

public class MyHashMap {
    Node[] table;
    int size;

    public MyHashMap() {
        table = new Node[16];
    }


    public void put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        // 计算hash值
        int hash = myHash(key.hashCode(), table.length);
        // 创建新节点
        Node newNode = new Node(key, value, hash);

        // 如果该位置为空，直接插入
        if (table[hash] == null) {
            table[hash] = newNode;
            size++;
            return;
        }

        // 遍历链表
        Node current = table[hash];
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
            Node current=table[i];
            while(current!=null){
                sb.append(current.key+"="+current.value+",");
                current=current.next;
            }
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public Object get(Object key) {
        int hash=myHash(key.hashCode(), table.length);
        Object value=null;

        if(table[hash]!=null){
            Node current=table[hash];

            while (current != null) {
                if (current.key.equals(key)) {
                    value=current.value;
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
        MyHashMap map=new MyHashMap();
        map.put(10,"a");
        map.put(20,"b");
        map.put(30,"ccc");

        map.put(53,"gg");
        map.put(69,"hh");

        System.out.println(map);

//        for(int i=0;i<100;i++){
//            System.out.println(i+"----"+myHash(i,16));
//        }

        System.out.println(map.get(20));
        System.out.println(map.get(53));

    }



}




