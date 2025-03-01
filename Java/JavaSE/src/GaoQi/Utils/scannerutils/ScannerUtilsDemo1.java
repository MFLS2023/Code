package GaoQi.Utils.scannerutils;

import java.util.Scanner;

public class ScannerUtilsDemo1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎，欢迎，热烈欢迎!");
        String name=scanner.nextLine();
        System.out.println("我叫"+name+" 你叫什么");
        String address=scanner.nextLine();
        System.out.println(address);
        scanner.close();
    }

}
