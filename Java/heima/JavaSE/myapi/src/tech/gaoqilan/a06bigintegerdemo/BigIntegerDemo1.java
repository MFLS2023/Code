package tech.gaoqilan.a06bigintegerdemo;

import java.math.BigInteger;
import java.util.Random;

public class BigIntegerDemo1 {
    public static void main(String[] args) {
        //1.获取一个随机的大整数
        Random r=new Random();
        for (int i = 0; i < 100; i++) {
            BigInteger bd1=new BigInteger(5,r);
            System.out.println(bd1);
        }
        //2.获取一个指定的大整数，字符串中必须要整数
        BigInteger bd2=new BigInteger("9999999999999999999999999999");
        System.out.println(bd2);

        //3.获取指定进制下的大整数（其实就是将该数字按照指定进制求出来）
        BigInteger bd4=new BigInteger("1011",10);
        System.out.println(bd4);

        //4.静态方法获取BigInteger的对象，有优化
        //在long的取值范围之内，
        //在内部对常用的数字 -16~16进行了优化 ,提前把这几个数字先创建好BigInteger的对象，
        BigInteger bd5=BigInteger.valueOf(100000);
        System.out.println(bd5);

        //如果long范围内的就使用 valueOf的方法，如果是不确定大小，使用 第二个方法
        /*
            BigInteger bd5 = BigInteger.valueOf(16);
            BigInteger bd6 = BigInteger.valueOf(16);

            System.out.println(bd5 == bd6); // true

            BigInteger bd7 = BigInteger.valueOf(17);
            BigInteger bd8 = BigInteger.valueOf(17);

            System.out.println(bd7 == bd8); // false
        */

// 5. 对象一旦创建，内容的数据就不能发生改变
        BigInteger bd9 = BigInteger.valueOf(1);
        BigInteger bd10 = BigInteger.valueOf(2);
        BigInteger result = bd9.add(bd10);
        System.out.println(result); // 3

// 此时，不会修改参与计算的 BigInteger 对象中的值，而是产生了一个新的 BigInteger 对象记录 3
        System.out.println(bd9 == result); // false
        System.out.println(bd10 == result); // false

    }
}
