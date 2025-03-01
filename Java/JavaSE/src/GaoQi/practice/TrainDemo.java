package GaoQi.practice;


class Train implements Runnable{
    @Override
    public void run(){
         int ticket=100;
        while(true){
            synchronized (this) {

                if(ticket>0){
                    System.out.println(Thread.currentThread().getName()+"卖出了第"+ticket+"张票");
                    ticket--;
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }

        }
    }
}
public class TrainDemo {
    public static void main(String[] args) {

        Train t=new Train();
        Thread t1=new Thread(t);
        t1.setName("窗口1");
        Thread t2=new Thread(t);
        t2.setName("窗口2");
        t1.start();
        t2.start();

    }
}
