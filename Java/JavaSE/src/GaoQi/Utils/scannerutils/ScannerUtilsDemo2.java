package GaoQi.Utils.scannerutils;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerUtilsDemo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的名字（英文）");

        String name=scanner.nextLine();
        int number;
        System.out.println("好的，我已经记住你的名字了\n下面请输入你的年龄吧");
        number=scanner.nextInt();
        System.out.println("好的，我已经记住你的年龄了\n下面请输入你的身高吧");
        double height=scanner.nextDouble();
        System.out.println("好的，我已经记住你的身高了\n下面请输入你的体重吧");
        float weight=scanner.nextFloat();
        System.out.println("好的，我已经记住你的体重了\n下面请输入你的性别吧");
        char gender =scanner.next().charAt(0);

        scanner.nextLine();
        System.out.print("下面请你开始输入你喜欢的明星吧");
        while(scanner.hasNext()){
            String world=scanner.next();
            System.out.println("您喜欢的明星是："+world);
        }
        scanner.nextLine();
        scanner.close();


    }
}
