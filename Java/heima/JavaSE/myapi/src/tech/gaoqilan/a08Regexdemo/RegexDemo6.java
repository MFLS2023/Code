package tech.gaoqilan.a08Regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo6 {
    public static void main(String[] args) {

        /*
        需求: 把下面文本中的电话、邮箱、手机号、热线都匹配出来.
        来源是黑马程序员学习Java.
        手机号: 185152815758, 18512580907
        联系方式邮箱: boniu@itcast.cn
        电话号码是: 010-989515785, 010-98951256
        备用邮箱是: bozai@itcast.cn.
        热线电话是: 400-618-4000, 4006184000, 4006189090
        */

        String s = "黑马程序员学习Java，" +
                "手机号: 185152815758, 18512580907" +
                "或者联系邮箱: boniu@itcast.cn，" +
                "电话号码是: 010-989515785, 010-98951256" +
                "备用邮箱是: bozai@itcast.cn，" +
                "热线电话是: 400-618-4000, 4006184000, 4006189090";

        // 正则表达式匹配手机号、邮箱、电话、热线
        String regex = "([1-9]\\d{9})|" +  // 匹配手机号
                "(\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2})|" +  // 匹配邮箱
                "(0\\d{2,3}-?[1-9]\\d{4,9})|" +  // 匹配电话号码
                "(400-[1-9]\\d{2}-?[1-9]\\d{3})";  // 匹配热线电话

        // 进行正则匹配
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        // 输出匹配到的结果
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
