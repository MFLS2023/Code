package tech.gaoqilan.a08Regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo7 {
    public static void main(String[] args) {


    /*
        需求1: 提取版本号为 8、11、17 的 Java 文本，但显示时只提取 Java，不显示版本号。
        需求2: 提取版本号为 8、11、17 的 Java 文本，提取后结果应为：Java8、Java11、Java17。
        需求3: 提取除了版本号为 8、11、17 的 Java 文本。
     */

        String s = "Java自从95年中诞生以来，经历了很多版本， 目前企业中间用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本， 下一个长期支持版本是Java17， 相信在未来不久Java17也会逐渐登上历史舞台";

        // 定义正则表达式
        // 提取分组前面的括号里的是Java
        // 要求后面的数字是8,11,17的版本
        // 需求1:

        //(?=...)：正向预查，用于断言某个模式后面存在，但不会包含在匹配结果中。
        //(?!...)：负向预查，用于断言某个模式后面不存在。
        //(?:...)：非捕获组，用于将部分模式进行分组匹配，但不存储结果。
        String regex1 = "((?i)Java)(?=8|11|17)";
        System.out.println("---------------11111111---------------");
        Pattern p = Pattern.compile(regex1);
        Matcher m;
        m = p.matcher(s);
        while(m.find()){
            System.out.println(m.group());
        }
        // 需求2:
        String regex2 = "((?i)Java)(8|11|17)";
        System.out.println("----2222-----------------");
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2;
        m2 = p2.matcher(s);
        while(m2.find()){
            System.out.println(m2.group());
        }
        String regex3 = "((?i)Java)(?:8|11|17)";
        System.out.println("-------222222222222222---------------");
        Pattern p3 = Pattern.compile(regex3);
        Matcher m3;
        m3 = p3.matcher(s);
        while(m3.find()){
            System.out.println(m3.group());
        }
        // 需求3:
        System.out.println("--------3333333333--------------");
        String regex4 = "((?i)Java)(?!8|11|17)";


            Pattern p4 = Pattern.compile(regex4);
            Matcher m4;
            m4 = p4.matcher(s);
            while(m4.find()){
                System.out.println(m4.group());
            }



    }
}














