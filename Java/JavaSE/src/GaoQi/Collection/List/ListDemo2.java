package GaoQi.Collection.List;

import java.util.ArrayList;
import java.util.Collection;

public class ListDemo2 {
    public static void main(String[] args) {
        // 创建ListDemo2对象并调用test1方法
        ListDemo2 demo = new ListDemo2();
        demo.test1();
    }

    // 将test1方法改为非静态方法
    public void test1(){
        Collection<String> c = new ArrayList<>();

        System.out.println(c.size());
        System.out.println(c.isEmpty());

        c.add("List1");
        c.add("List2");

        System.out.println(c);
        System.out.println(c.size());

        Object[] arr = c.toArray();
        // 修改输出数组的方式
        for(Object obj : arr){
            System.out.print(obj + " ");
        }
        System.out.println(); // 换行

        System.out.println(c.contains("List1"));

        c.remove("List1");
        System.out.println(c);

        c.clear();
        System.out.println(c.isEmpty());
        System.out.println(c);
    }
}
