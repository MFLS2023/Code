package GaoQi.thread;

public class RunnableDemo {
    public static void main(String[] args) {

        EvenNumber evenNumber = new EvenNumber();
        new Thread(evenNumber,"线程1: ").start();

        OddNumber oddNumber = new OddNumber();
        new Thread(oddNumber).start();

        EvenNumber testNumber=new EvenNumber();
        Thread t=new Thread(testNumber,"线程3: ");
        t.start();

    }
}

class EvenNumber implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}

class OddNumber implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}


