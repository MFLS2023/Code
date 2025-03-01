package tech.gaoqilan.a01mathdemo1;

public class MathDemo1 {
    public static void main(String[] args) {
        /*
            public Math
         */

        System.out.println("abs");
        System.out.println(Math.abs(-99));
        System.out.println(Math.abs(-99.99));
        System.out.println("ceil-----------------------");
        System.out.println(Math.ceil(12.34));
        System.out.println(Math.ceil(12.54));
        System.out.println(Math.ceil(-12.34));
        System.out.println("floor-----------------------------------");
        System.out.println(Math.floor(12.34));
        System.out.println(Math.floor(12.54));
        System.out.println(Math.floor(-12.34));
        System.out.println("round-------------------");
        System.out.println(Math.round(12.34));
        System.out.println(Math.round(12.54));
        System.out.println(Math.round(-12.34));
        System.out.println("max---------------------");
        System.out.println(Math.max(12.34, 12.54));
        System.out.println("min---------------------");
        System.out.println(Math.min(12.34, 12.54));
        System.out.println("pow------------------");
        System.out.println(Math.pow(2,2));
        System.out.println(Math.pow(2, -2));
        System.out.println(Math.pow(2,0.5));
        System.out.println("sqrt------------------");
        System.out.println(Math.sqrt(2));
        System.out.println(Math.sqrt(-2));
        System.out.println("cbrt----------------------");
        System.out.println(Math.cbrt(8));
        System.out.println("random-------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.println(Math.random());
        }

        //判断一个数是否为质数
        System.out.println(isPrime(2));

        //判断水仙花数，自幂数  三位数：水仙花数 四位自幂数：四夜玫瑰数 五位自幂数：五角星数

    }
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
