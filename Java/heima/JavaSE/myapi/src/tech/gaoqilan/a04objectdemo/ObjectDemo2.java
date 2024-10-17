package tech.gaoqilan.a04objectdemo;

public class ObjectDemo2 {
    public static void main(String[] args) {
        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");

        System.out.println(s.equals(sb)); // false
        // 1. equals 方法是字符串的判断，而 sb 是字符串
        // 2. 所以调用的是 String 的 equals 方法
        // 3. 看源码的 equals 方法，先判断参数是否为字符串
        // 4. 如果不是字符串，直接返回 false，不会再去比较内容
        // 5. 由于 sb 是 StringBuilder 对象，而不是字符串
        // 6. 于是类型不符合，内容也不同，最终返回 false

        System.out.println(sb.equals(s)); // false
        // 1. equals 方法是 StringBuilder 的方法，而不是 StringBuilder
        // 2. 所以调用的是 StringBuilder 的 equals 方法
        // 3. 看 StringBuilder 的源码，没有重写 equals 方法
        // 4. 所以还是调用 Object 的 equals 方法
        // 5. Object 类中的 equals 使用 == 比较两个对象的地址值
        // 6. 而当前的 sb 和 s 地址值显然是不一样的，所以结果返回 false
    }
}

