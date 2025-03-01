package GaoQi.thread.safe.singleton;

public class SingletonDemo {
    static Bank b1=null;
    static Bank b2=null;

    public static void main(String[] args) {

        Thread t1=new Thread(){
            @Override
            public void run() {
                b1=Bank.getInstance();
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                b2=Bank.getInstance();
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1==b2);
    }

}

class Bank{
    private Bank(){}

    private static volatile Bank instance=null;


    //法三
    public static Bank getInstance(){
        if(instance==null) {

            synchronized (Bank.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Bank();
                }
            }
        }
        return instance;
    }



        //法1
//    public static synchronized Bank getInstance(){
//        if(instance==null){
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            instance=new Bank();
//        }
//        return instance;
//    }

    //法2
//    public static Bank getInstance(){
//        synchronized(Bank.class){
//            if(instance==null){
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                instance=new Bank();
//            }
//        }
//        return instance;
//    }
}
