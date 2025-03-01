package tech.gaoqilan.a06bigintegerdemo;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerDemo2 {
    public static void main(String[] args) {
        //1.创建两个BigInteger对象
        BigInteger bd1=BigInteger.valueOf(10);
        BigInteger bd2=BigInteger.valueOf(3);
        //2.加法
        BigInteger bd3=bd1.add(bd2);
        System.out.println(bd3);
        //3.除法，获取商和余数
        BigInteger[]arr=bd1.divideAndRemainder(bd2);
        System.out.println(arr[0]);
        System.out.println(arr[1]);

        // 5. 次幂
        BigInteger bd4 = bd1.pow(2);
        System.out.println(bd4);

        // 6. max
        BigInteger bd5 = bd1.max(bd2);
        System.out.println(bd5);

        // 7. 转为 int 类型整数，超出范围数据有误
        /*
        BigInteger bd6 = BigInteger.valueOf(2147483647L);
        int i = bd6.intValue();
        System.out.println(i);
        */

        BigInteger bd6 = BigInteger.valueOf(2147483647L);
        double v1 = bd6.doubleValue();
        System.out.println(v1); //int最大整数
        BigInteger bd7 = BigInteger.valueOf(200);
        double v2 = bd7.doubleValue();
        System.out.println(v2); // 200.0

    }
}
