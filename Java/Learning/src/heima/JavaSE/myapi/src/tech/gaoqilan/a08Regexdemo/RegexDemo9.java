package tech.gaoqilan.a08Regexdemo;

import sun.security.util.ResourcesMgr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo9 {
    public static void main(String[] args) {

        // 需求1：判断一个字符串的开头存的和结束字符是否一致 只考虑一个字符
        // 示例: a123a b456b 17891 8a8c8 a123b(false)
        // \\组号:表示把第X组的内容再出来用一次
        String regex1 = "(.).+\\1";
        System.out.println("a123a".matches(regex1));
        System.out.println("b456b".matches(regex1));
        System.out.println("17891".matches(regex1));
        System.out.println("8a8c8".matches(regex1));
        System.out.println("a123b".matches(regex1));

        System.out.println("--------------------------");

        // 需求2：判断一个字符串的开头部分和结尾部分是否一致 可以包含多个字符
        // 示例: abc123abc b456b 123789123 &!@abc8!@ abc123abd(false)
        String regex2 = "(.+).+\\1";
        System.out.println("abc123abc".matches(regex2));
        System.out.println("b456b".matches(regex2));
        System.out.println("123789123".matches(regex2));
        System.out.println("&!@abc8!@".matches(regex2));
        System.out.println("abc123abd".matches(regex2));

        // 需求3：判断一个字符串的开头部分和结尾部分是否一致？开始部分内部包含个字符也需要一致
        // 示例: aaa123aaa bbb456bbb 111789111 &&abc&&
        String regex3 = "((.)\\2+).+\\1";// + 换 * 也可以
        // (.)：把首字符存储做一组
        // \\2：把首字符拿出来再使用  为什么是 2呢 因为这是 第二组（第一个元素）
        // * 作用于\\2，表示后面重复的内容出现0次或多次
        System.out.println("-----------------------");
        System.out.println("aaa123aaa".matches(regex3));
        System.out.println("bbb456bbb".matches(regex3));
        System.out.println("111789111".matches(regex3));
        System.out.println("&&abc&&".matches(regex3));
        System.out.println("aaa123aab".matches(regex3));

    }
}














