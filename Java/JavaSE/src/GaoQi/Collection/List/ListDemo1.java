package GaoQi.Collection.List;


import java.util.*;

public class ListDemo1 {
    public static void main(String[] args) {

        Collection<String> c=new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("List1");
        c.add("List2");

        System.out.println(c);
        System.out.println(c.size());

        Object[] arr=c.toArray();
        System.out.println(arr);

        System.out.println(c.contains("List1"));

        c.remove("List1");
        System.out.println(c);

        c.clear();
        System.out.println(c.isEmpty());
        System.out.println(c);


    }
}
