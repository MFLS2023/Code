package tech.gaoqilan.a04objectdemo;

public class ObjectDemo3 {
    public static void main(String[] args) {
        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");

        System.out.println(s.equals(sb)); // false
        // 1. equals 方法是 String 类中的方法，此时调用的是 String 的 equals 方法。
        // 2. String 的 equals 方法首先会判断传入的参数是否为 String 类型。
        // 3. 如果不是 String 类型（比如传入的是 StringBuilder），则直接返回 false，不比较内容。
        // 4. 因为 sb 是 StringBuilder 对象，不是 String，因此返回 false。

        System.out.println(sb.equals(s)); // false
        // 1. 这里调用的是 StringBuilder 类的 equals 方法。
        // 2. StringBuilder 没有重写 Object 类的 equals 方法，所以调用的是 Object 类中的 equals 方法。
        // 3. Object 类中的 equals 方法使用 == 比较两个对象的内存地址（引用）。
        // 4. 由于 s 和 sb 是两个不同类型的对象，内存地址不同，所以返回 false。
    }
}


