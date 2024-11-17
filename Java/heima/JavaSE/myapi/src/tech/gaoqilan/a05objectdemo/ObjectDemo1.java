package tech.gaoqilan.a05objectdemo;

import java.util.Objects;

public class ObjectDemo1 {
    public static void main(String[] args) {
        // 1. 创建学生类的对象
        Student s1 = null;
        Student s2 = new Student("zhangsan", 23);


        // 2. 比较两个对象的属性值是否相同
        if (s1 != null) {
            boolean result = s1.equals(s2);
            System.out.println(result);
        } else {
            System.out.println("调用者为空");
        }


        boolean result = Objects.equals(s1, s2);
        System.out.println(result);
        /*
            细节：
            // 1. 方法底层会先判断第一个对象是否为 null，如果为 null，直接返回 false
            // 2. 如果第一个对象不为 null，那么会判断第二个对象是否为 null
            // 3. 如果第一个对象是 Student 类型，则最终底层还是会调用 Student 中的 equals 方法
            // 4. 建议我们自己写 equals 方法，如果要重写，就比较属性值。
        */

        // public static boolean isNull(Object obj) 判断对象是否为 null，为 null 返回 true，反之

        Student s3 = new Student();
        Student s4 = null;

        System.out.println(Objects.isNull(s3)); // false
        System.out.println(Objects.isNull(s4)); // true

        System.out.println(Objects.nonNull(s3)); // true
        System.out.println(Objects.nonNull(s4)); // false
        
    }
}
