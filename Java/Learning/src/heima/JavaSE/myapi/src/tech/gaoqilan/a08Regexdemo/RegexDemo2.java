package tech.gaoqilan.a08Regexdemo;

public class RegexDemo2 {
    public static void main(String[] args) {

        // public boolean matches(String regex): 判断是否与正则表达式匹配，匹配返回 true
        // . 表示任意一个字符
        System.out.println("你".matches(".")); // false
        System.out.println("a".matches(".")); // true

        // \d 用于匹配任意的一位数字
        System.out.println("a".matches("\\d")); // false
        System.out.println("3".matches("\\d")); // true
        System.out.println("333".matches("\\d")); // false

        // \w 用于匹配一位单词字符 [a-zA-Z_0-9]
        System.out.println("z".matches("\\w")); // true
        System.out.println("2".matches("\\w")); // true
        System.out.println("Z1".matches("\\w")); // false
        System.out.println("你".matches("\\w")); // false

        // \W 非单词字符
        System.out.println("你".matches("\\W")); // true
        System.out.println("a".matches("\\W")); // false

        // 必须是数字、字母、下划线，至少6位
        System.out.println("2442fsfsf".matches("\\w{6,}")); // true
        System.out.println("244f".matches("\\w{6,}")); // false

        // 必须是数字和字母，必须是 4 位
        System.out.println("23dF".matches("[a-zA-Z0-9]{4}")); // true
        System.out.println("23_F".matches("[a-zA-Z0-9]{4}")); // false
        System.out.println("23dF".matches("[\\w&&[^_]]{4}")); // true
        System.out.println("23_F".matches("[\\w&&[^_]]{4}")); // false


    }

}
