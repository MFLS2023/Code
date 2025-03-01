package GaoQi.Collection.Collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        for(int i=0;i<100;i++){
            list.add("gao:"+i);
        }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "zhangsan"));
        System.out.println(Collections.binarySearch(list,"gao:1"));

    }
}
