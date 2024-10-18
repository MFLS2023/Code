package tech.gaoqilan.a08Regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo4 {
    public static void main(String[] args) {
        /*
        Java自从95年中推出以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，因为这两个是长期支持版本。下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台。

         */
        // 文本字符串
        String str = "Java自从95年中推出以来，经历了很多版本，目前企业中用的最多的是Java8和Java11，" +
                "因为这两个是长期支持版本。下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台。";

        // 正则表达式模式
        Pattern pattern = Pattern.compile("Java\\d+");

        // 创建匹配器对象
        //matcher：文本匹配器的对象 str：大串 pattern：规则
        //就是 matcher要在str中寻找符合pattern规则的小串
        Matcher matcher = pattern.matcher(str);

        // 遍历找到的匹配项
        while (matcher.find()) {
            System.out.println(matcher.group()); // 输出匹配到的Java版本号
        }
    }
}
