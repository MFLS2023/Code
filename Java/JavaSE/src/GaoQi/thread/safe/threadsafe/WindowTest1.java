package GaoQi.thread.safe.threadsafe;



class Windows1 extends Thread {
    static int ticket=100;
    static Object obj=new Object();
    static boolean isFlag=true;
    @Override
    public void run(){
        while(isFlag){
            show();
        }
    }

    //也可以直接 public static
    public  void show() {
        synchronized (Windows1.class) {
            if (ticket > 0) {
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + ticket + "张票");
                ticket--;
            }else{
                isFlag=false;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Windows1 w1=new Windows1();
        Windows1 w2=new Windows1();
        Windows1 w3=new Windows1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}

