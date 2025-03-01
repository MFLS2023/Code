package GaoQi.IO.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintStreamDemo1 {
    public static void main(String[] args) {
        PrintStream ps = System.out;
        ps.println("沉默王二");
        ps.print("沉 ");
        ps.print("默 ");
        ps.print("王 ");
        ps.print("二 ");
        ps.println();

        ps.printf("姓名：%s，年龄：%d，成绩：%f", "沉默王二", 18, 99.9);

        int num = 123;
        System.out.printf("%5d\n", num); // 输出 "  123"
        System.out.printf("%-5d\n", num); // 输出 "123  "
        System.out.printf("%05d\n", num); // 输出 "00123"

        double pi = Math.PI;
        System.out.printf("%10f\n", pi); // 输出 "3.141592653589793"
        System.out.printf("%15f\n",pi);
        System.out.printf("%10.2f\n", pi); // 输出 "      3.14"
        System.out.printf("%-10.4f\n", pi); // 输出 "3.1416    "

        String name = "沉默王二";
        System.out.printf("%10s\n", name); // 输出 "     沉默王二"
        System.out.printf("%-10s\n", name); // 输出 "沉默王二     "

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\printstream\\printstreamdemo1.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        writer.println("沉默王二");
        writer.printf("他的年纪为 %d.\n", 18);
        writer.close();

    }

}
