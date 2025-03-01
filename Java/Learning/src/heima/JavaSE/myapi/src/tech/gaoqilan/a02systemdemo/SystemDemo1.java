package tech.gaoqilan.a02systemdemo;

public class SystemDemo1 {


    public static void main(String[] args) {

        //0：表示当前虚拟机是正常停止
        //非0：表示当前虚拟机异常停止

//        System.exit(0);
//        System.out.println("虚拟机停止了吗");

        long l = System.currentTimeMillis();
        System.out.println(l);

    }
}
