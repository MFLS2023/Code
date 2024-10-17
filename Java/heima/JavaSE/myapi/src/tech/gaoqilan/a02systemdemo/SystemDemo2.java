package tech.gaoqilan.a02systemdemo;

public class SystemDemo2 {
    public static void main(String[] args) {
        //获取程序运行时间
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            boolean flag=isPrime1(i);
            if(flag){
                System.out.println(i);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-----------------");
        System.out.println(endTime-startTime);
    }


    //原始方法
    public static boolean isPrime1(int number){
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }


    //新的
    public static boolean isPrime(int number) {
        int count=0;
        if(number<2){
            return false;
        }else if((number&2)==1){
            return false;
        }else{
            for (int i = 2; i <=Math.sqrt(number) ; i++) {
                if(number%i==0){
                    return false;
                }
            }
        }
        return true;
    }
}
