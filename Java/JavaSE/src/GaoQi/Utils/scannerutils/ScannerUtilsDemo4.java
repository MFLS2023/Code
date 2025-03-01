package GaoQi.Utils.scannerutils;

import java.util.Scanner;

public class ScannerUtilsDemo4 {
    public static void main(String[] args) {
        String input="chong chong chong    jiu shi gan   gan jiu wan le";
        Scanner scanner=new Scanner(input);

        String result=scanner.findInLine("chong");
        System.out.println("findInLine(\"chong\")="+result);

        scanner=new Scanner(input);
        result=scanner.findWithinHorizon("gan",20);
        System.out.println("findWithinHorizon():"+result);
        scanner.close();


    }
}
