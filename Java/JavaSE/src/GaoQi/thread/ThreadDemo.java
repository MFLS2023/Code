package GaoQi.thread;

public class ThreadDemo {
    public static void main(String[] args) {

        //方式一
        PrintNumber p=new PrintNumber();
        p.setName("线程1");
        p.start();

        for(int i=0;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

//        //方式二
//        new Thread(){
//            public void run(){
//                for(int i=0;i<100;i++){
//                    System.out.println(Thread.currentThread().getName()+"方式二:"+i);
//                }
//            }
//        }.start();

        //方式三：使用Runnable接口方式，（提供了Runnable接口匿名实现类的匿名对象
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                for(int i=0;i<100;i++){
//                    System.out.println(Thread.currentThread().getName()+"方式三:"+i);
//                }
//            }
//        }).start();
    }
}

class PrintNumber extends Thread{
    @Override
    public void run(){
        for(int i=0;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
