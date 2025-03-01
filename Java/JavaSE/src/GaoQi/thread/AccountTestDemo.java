package GaoQi.thread;

public class AccountTestDemo {
    public static void main(String[] args) {
    Account account=new Account();
    Customer customer1=new Customer(account,"A");
    Customer customer2=new Customer(account,"B");
    customer1.start();
    customer2.start();
    }
}

class Account{
    private  double balance;
    public synchronized void deposit(double amt){
        if(amt>0){
            balance+=amt;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"存钱1000块，余额为："+balance);
    }
}

class Customer extends Thread{
    Account account;
    public Customer(Account account){
        this.account=account;
    }

    public Customer(Account account,String name){
        super(name);
        this.account=account;
    }

    public void run(){
        for(int i=0;i<3;i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.deposit(1000);
        }
    }

}