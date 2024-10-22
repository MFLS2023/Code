package tech.gaoqilan.a08Regexdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo5 {
    public static void main(String[] args) throws IOException {

        // 指定URL地址
        URL url = new URL("https://www.gaoqilan.tech/category/Code");
        URLConnection conn = url.openConnection();

        // 读取网页内容
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;

        // 正则表达式
        String regex = "[1-9]\\d{17}";
        Pattern pattern = Pattern.compile(regex);

        // 按行读取网页内容
        while ((line = br.readLine()) != null) {
            System.out.println(line);

            // 查找匹配
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        }

        br.close(); // 关闭流
    }
}
