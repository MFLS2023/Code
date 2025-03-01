package GaoQi.thread;


class PinrtNumber implements Runnable{
    private int number=1;
    Object obj=new Object();
    @Override
    public void run(){
        while(true){

//            synchronized (this) {
            synchronized(obj){

                obj.notify();

                if(number<=100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+number++);
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    break;
                }
            }
        }
    }
}

public class PrintNumberTest {
    public static void main(String[] args) {

        PrintNumber p=new PrintNumber();
        Thread t1=new Thread(p,"线程1");
        Thread t2=new Thread(p,"线程2");
        t1.start();
        t2.start();
    }
}
