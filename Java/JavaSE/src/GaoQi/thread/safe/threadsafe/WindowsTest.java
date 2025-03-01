package GaoQi.thread.safe.threadsafe;



class Window extends Thread{
    static int ticket=100;



    @Override
    public void run(){
        while(true){
            synchronized (Window.class) {
                if(ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"张票");
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}

public class WindowsTest {
    public static void main(String[] args) {

        Window w1=new Window();
        Window w2=new Window();
        Window w3=new Window();

        w1.start();
        w2.start();
        w3.start();
    }

}
