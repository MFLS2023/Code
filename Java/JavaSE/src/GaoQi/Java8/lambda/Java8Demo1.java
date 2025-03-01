package GaoQi.Java8.lambda;

public class Java8Demo1 {
    public static void main(String[] args) {

        Runnable r1=new Runnable(){
            @Override
            public void run(){
                System.out.println("传统方式");
            }
        };

        Runnable r2=()->System.out.println("Lambda方式");

        Runnable r3=()->{
            System.out.println("第一行");
            System.out.println("第二行");
        };

        r1.run();
        r2.run();
        r3.run();

        new Thread(()-> System.out.println("真的要玉玉了，手机摔碎了")).start();

    }
}
