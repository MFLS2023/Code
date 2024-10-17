package tech.gaoqilan.a08Regexdemo;

public class RegexDemo1 {
    public static void main(String[] args) {

        // public boolean matches(String regex): 判断是否与正则表达式匹配，匹配返回 true

        // 1. 只匹配 a b c
        System.out.println("a".matches("[abc]")); // true
        System.out.println("z".matches("[abc]")); // false
        System.out.println("ab".matches("[abc]")); // false
        System.out.println("ab".matches("[abc][abc]")); // true

        // 2. 不匹配 a b c
        System.out.println("a".matches("[^abc]")); // false
        System.out.println("z".matches("[^abc]")); // true
        System.out.println("zz".matches("[^abc]")); // false
        System.out.println("zz".matches("[^abc][^abc]")); // true

        // 3. 匹配 a 到 z 或 A 到 Z（包括头尾范围）
        System.out.println("a".matches("[a-zA-Z]")); // true
        System.out.println("Z".matches("[a-zA-Z]")); // true
        System.out.println("aa".matches("[a-zA-Z]")); // false
        System.out.println("z".matches("[a-zA-Z]")); // true
        System.out.println("a".matches("[a-zA-Z]")); // true
        System.out.println("Z".matches("[a-zA-Z]")); // true
        System.out.println("0".matches("[a-zA-Z]")); // false
        System.out.println("0".matches("[a-zA-Z0-9]")); // true
        System.out.println("0".matches("[0-9]")); // true

        // [a-d[m-p]] a 到 d 或 m 到 p
        System.out.println("a".matches("[a-d[m-p]]")); // true
        System.out.println("d".matches("[a-d[m-p]]")); // true
        System.out.println("m".matches("[a-d[m-p]]")); // true
        System.out.println("p".matches("[a-d[m-p]]")); // true
        System.out.println("e".matches("[a-d[m-p]]")); // false
        System.out.println("0".matches("[a-d[m-p]]")); // false

        // [a-z&&[def]] a-z 和 def 的交集，为：d、e、f
        System.out.println("a".matches("[a-z&&[def]]")); // false
        System.out.println("d".matches("[a-z&&[def]]")); // true
        System.out.println("e".matches("[a-z&&[def]]")); // true
        System.out.println("f".matches("[a-z&&[def]]")); // true
        System.out.println("0".matches("[a-z&&[def]]")); // false

        // [a-z&&[^bc]] a-z 和非 bc 的交集。（等同于 [ad-z]）
        System.out.println("a".matches("[a-z&&[^bc]]")); // true
        System.out.println("b".matches("[a-z&&[^bc]]")); // false
        System.out.println("c".matches("[a-z&&[^bc]]")); // false
        System.out.println("0".matches("[a-z&&[^bc]]")); // false

        // [a-z&&[^m-p]] a 到 z 和除了 m 到 p 的交集。（等同于 [a-lq-z]）
        System.out.println("a".matches("[a-z&&[^m-p]]")); // true
        System.out.println("m".matches("[a-z&&[^m-p]]")); // false
        System.out.println("p".matches("[a-z&&[^m-p]]")); // false
        System.out.println("0".matches("[a-z&&[^m-p]]")); // false

    }

}
