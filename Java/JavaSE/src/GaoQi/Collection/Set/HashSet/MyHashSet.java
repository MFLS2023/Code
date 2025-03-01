package GaoQi.Collection.Set.HashSet;

import java.util.HashMap;

public class MyHashSet {

    HashMap map;
    private static final Object PRESENT = new Object();

    public MyHashSet(){
        map=new HashMap();

    }

    public int size(){
        return map.size();
    }
    public void add(Object value){
        map.put(value,PRESENT);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for(Object key:map.keySet()){
            sb.append(key+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        MyHashSet set=new MyHashSet();
        set.add("aa");
        set.add("bbb");
        System.out.println(set);

    }
}
