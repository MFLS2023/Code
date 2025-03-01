package GaoQi.Java8.lambda;

public class Java8Demo4 {
    public static void main(String[] args) {
        new Java8Demo4().work();
    }

    public void work(){
        System.out.println("----------first----------------");
        System.out.printf("this = %s%n", this);

        System.out.println("------------second----------------");
        Runnable r=new Runnable(){
            @Override
            public void run(){
                System.out.printf("this = %s%n", this);
            }
        };

        System.out.println("---------------third-----------------");
        new Thread(r).start();
        new Thread(()->System.out.printf("this=%s%n",this)).start();

    }
}
