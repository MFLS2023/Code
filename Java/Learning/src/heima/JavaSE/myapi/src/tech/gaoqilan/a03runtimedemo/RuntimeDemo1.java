package tech.gaoqilan.a03runtimedemo;

import java.io.IOException;

public class RuntimeDemo1 {
    public static void main(String[] args) throws IOException {
        //1/获取Runtime的对象
//        Runtime runtime = Runtime.getRuntime();
//        Runtime runtime2 = Runtime.getRuntime();
//        System.out.println(runtime==runtime2);

        //2.exit停止虚拟机
//        Runtime.getRuntime().exit(0);
//        //和下面的一致，上面是原始的
//        Runtime runtime3 = Runtime.getRuntime();
//        runtime3.exit(0);

        //3.获取cpu线程数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //4.总内存大小，单位byte字节，/1024 kb 再/1024 mb
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);

        //5.已经获取的总内存大小，单位byte字节
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);

        //5.剩余内存大小
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);

        //6.运行cmd命令
        Runtime.getRuntime().exec("notepad");
        //shutdown：关机，加上参数才能执行
        // -s:默认1min后关机
        //-s -t 指定时间 ： 指定关机时间
        //-a 取消关机操作
        //-r 关机并重启
        Runtime.getRuntime().exec("shutdown -s -t 3600");
        Runtime.getRuntime().exec("shutdown -a");





    }
}
