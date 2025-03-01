package tech.gaoqilan.a08Regexdemo;

public class RegexDemo10 {
    public static void main(String[] args) {

        /*
        需求：
        将字符串: 我要学学编编编编程程程程程程
        替换为: 我要学编程
        */

        String str = "我要学学编编编编程程程程程程";

        // 需求：把重复的内容 替换为 单个的
        // 学学 -> 学
        // 编编编编 -> 编
        // 程程程程程程 -> 程
        // (.) 表示把重复内容的第一个字符存储做一组
        // \\1 表示第一个字符
        // + 表示至少出现一次
        // $1 表示正则表达式中第一个组的内容，再拿出来使用
        String result = str.replaceAll("(.)\\1+", "$1");
        System.out.println(result);

    }
}














