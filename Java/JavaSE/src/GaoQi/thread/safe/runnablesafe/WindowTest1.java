package GaoQi.thread.safe.runnablesafe;

class SaleTicket1 implements Runnable {
    int ticket=100;
    Object obj=new Object();
    boolean isFlag=true;
    @Override
    public void run(){
        while(isFlag){
            show();
        }
    }

    private synchronized void show() {
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


public class WindowTest1 {
    public static void main(String[] args) {

        SaleTicket1 s = new SaleTicket1();
        Thread t1 = new Thread(s);
        Thread t2 = new Thread(s);
        Thread t3 = new Thread(s);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
