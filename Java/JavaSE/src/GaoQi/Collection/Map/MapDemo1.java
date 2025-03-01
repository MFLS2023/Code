package GaoQi.Collection.Map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo1 {
    public static void main(String[] args) {

        Map<Integer,String> m1=new HashMap<>();

        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");

        m1.get(1);
        System.out.println(m1);

        System.out.println(m1.size());

        System.out.println(m1.isEmpty());
        m1.containsKey(5);
        m1.containsValue("two");

        Map<Integer,String>m2=new HashMap<>();
        m2.put(4,"four");
        m2.put(5,"five");
        System.out.println(m2);
        m2.put(5,"6666666666");
        System.out.println(m2);
        System.out.println("**************");
        m1.putAll(m2);

        System.out.println(m1);

        m1.remove(2);

        System.out.println(m1);


        m1.clear();

        System.out.println(m1);

        System.out.println(m1.keySet());
        System.out.println(m1.values());
        System.out.println();

    }
}
