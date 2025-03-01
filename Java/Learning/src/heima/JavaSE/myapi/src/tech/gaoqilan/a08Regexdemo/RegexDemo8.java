package tech.gaoqilan.a08Regexdemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo8 {
    public static void main(String[] args) {

        /*
          只写* 和+ 表示贪婪匹配
          *? +? 非贪婪匹配
          贪婪模式：在匹配数据的时候尽可能的多获取数据
          非贪婪模式：在匹配数据的时候尽可能的少获取数据

          ab*:
          贪婪模式：abbbbbbbbbbbbbb
          非贪婪模式：ab

          "Java" 当中，默认的是非贪婪匹配
          如果我们在数量词 +  的后面加上 ? 的话，那么此时就是非贪婪匹配。
        */

        String s = "Java自从95年中世以来，abbbbbbbbbbbbbbaaaaaaaaaaaaaaaaaaaaa" +
                "经历了很多版本，当前企业中用的最多的是Java8和Java11，因为这两个是长期支持版本，" +
                "下一个长期支持版本是Java17，相信在未来不久Java17也会逐渐登上历史舞台";

        String regex = "ab+?";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);

        while(m.find()){
            System.out.println(m.group());
        }




    }
}














