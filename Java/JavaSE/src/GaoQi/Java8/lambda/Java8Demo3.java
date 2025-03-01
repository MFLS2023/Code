package GaoQi.Java8.lambda;

import java.util.concurrent.atomic.AtomicInteger;

public class Java8Demo3 {
    static int limit=11110;
    public static void main(String[] args) {
        Runnable r=()->{
            limit=5;
            for(int i=0;i<limit;i++){
                System.out.println(i);
            }
        };

        new Thread(r).start();

        final AtomicInteger limit2=new AtomicInteger(10);
        Runnable r2 =()->{
            limit2.set(5);
            for(int i=0;i<limit2.get();i++){
                System.out.println(i);
            }
        };
        new Thread(r2).start();

        System.out.println("---------second------------------");

        final int[]limits={10};
        Runnable r3=()->{
            limits[0]=5;
            for(int i=0;i<limits[0];i++){
                System.out.println(i);
            }
        };
        new Thread(r3).start();
        System.out.println("---------third------------------");
    }
}
