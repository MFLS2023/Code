package GaoQi.Collection.Iterator;

import java.util.*;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Map;

public class IteratorDemo1 {
    public static void main(String[] args) {
        IteratorList();
        IteratorSet();
        IteratorMap();
    }
    public static void IteratorList(){
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        for(Iterator<String> iter = list.iterator(); iter.hasNext();){
            String current=iter.next();
            System.out.println(current);
        }
    }

    public static void IteratorSet(){
        Set<String> set=new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");

        for(Iterator<String>iter=set.iterator();iter.hasNext();){
            String current =iter.next();
            System.out.println(current);

        }

    }

    public static void IteratorMap(){
        Map<Integer,String> map=new HashMap<>();
        map.put(100,"a");
        map.put(200,"b");
        map.put(300,"c");

        Set<Entry<Integer,String>> ss=map.entrySet();
        for(Iterator<Entry<Integer,String>> iter = ss.iterator(); iter.hasNext();){
            Map.Entry<Integer,String> current=iter.next();
            System.out.println(current.getKey()+":"+current.getValue());
        }

        Set<Integer>keySet=map.keySet();
        for(Iterator<Integer>iter=keySet.iterator();iter.hasNext();){
            Integer key=iter.next();
            System.out.println(key+"----"+map.get(key));

        }
    }



}
