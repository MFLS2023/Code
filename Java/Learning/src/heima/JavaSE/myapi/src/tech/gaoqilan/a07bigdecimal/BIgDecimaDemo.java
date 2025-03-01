package tech.gaoqilan.a07bigdecimal;

import java.math.BigDecimal;

public class BIgDecimaDemo {
    public static void main(String[] args) {

        // 1. 通过传递 double 类型的小数来创建对象
        // 细节：这种方式可能是不精确的，所以不建议使用
        BigDecimal bd1 = new BigDecimal(0.01);
        BigDecimal bd2 = new BigDecimal(0.09);
        System.out.println(bd1);
        System.out.println(bd2);

        // 2. 通过字符串的形式表示的小数来创建对象
        BigDecimal bd3 = new BigDecimal("0.01");
        BigDecimal bd4 = new BigDecimal("0.09");
        BigDecimal bd5 = bd3.add(bd4);
        System.out.println(bd3);
        System.out.println(bd4);
        System.out.println(bd5);

        // 3. 通过静态方法获取对象
        BigDecimal bd6 = BigDecimal.valueOf(10);
        BigDecimal bd7 = BigDecimal.valueOf(10);
        BigDecimal bd8 = BigDecimal.valueOf(10.0);
        BigDecimal bd9 = BigDecimal.valueOf(10.0);


        System.out.println(bd6);
        // 细节：
        // 1. 如果表示的数字不大，没有超出 double 的取值范围，建议使用静态方法
        // 2. 如果表示的数字较大，超出了 double 的取值范围，建议使用构造方法
        // 3. 如果传递的是 0~10 之间的整数，包括 0，包含 10，那么方法会返回已经创建好的对象，不会重新 new

        System.out.println(bd6==bd7);
        System.out.println(bd7==bd8);
        System.out.println(bd8==bd9);


    }
}
