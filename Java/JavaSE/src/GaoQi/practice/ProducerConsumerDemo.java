package GaoQi.practice;

class Producer implements Runnable {
    @Override
    public void run() {
        while(true) {
            if(ProducerConsumerDemo.number >= 20) {
                try {
                    Thread.sleep(2000);  // 缓冲区满了，休眠一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "生产了一个产品");
                ProducerConsumerDemo.number++;
            }

            try {
                Thread.sleep(700);  // 生产一个后稍微休息一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements Runnable {
    @Override
    public void run() {
        while(true) {
            if(ProducerConsumerDemo.number <= 0) {
                try {
                    Thread.sleep(2000);  // 缓冲区空了，休眠一段时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + "消费了一个产品");
                ProducerConsumerDemo.number--;
            }

            try {
                Thread.sleep(500);  // 消费一个后稍微休息一下
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumerDemo {
    public static int number = 0;

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
