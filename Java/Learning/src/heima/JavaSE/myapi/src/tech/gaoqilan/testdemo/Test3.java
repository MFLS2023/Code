package tech.gaoqilan.testdemo;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        /*
            定义一个方法自己实现toBinaryString将十进制转换成字符串表示的二进制

         */
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        System.out.println(toBinaryString(a));

        //
    }
    public static String toBinaryString(int number) {
        //核心逻辑：不断的去除以2，得到余数，直到为0为止
        //然后拼接起来

        //定义一个StringBuilder用来拼接变量
        StringBuilder sb = new StringBuilder();

        //循环
        while(true){
            if(number==0){
                break;
            }
            //获取余数
            int remainder = number % 2;
            //倒着拼接,后面再返回，或者下面的头插法
            sb.append(remainder);

            //sb.insert(0, remainder);
            //除以2
            number = number / 2;
        }
        sb.reverse();
        return sb.toString();
    }
}
