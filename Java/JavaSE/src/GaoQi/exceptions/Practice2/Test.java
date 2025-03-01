package GaoQi.Exceptions.Practice2;

import java.util.Scanner;
import java.io.IOException;
public class Test {
    public static void main(String[] args) throws IOException{
        int divdend;
        int divisor;

        try{
            Scanner sc=new Scanner(System.in);
            divdend=sc.nextInt();
            divisor=sc.nextInt();
            System.out.println(divdend/divisor);
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("总是被执行");
        }
    }
}
