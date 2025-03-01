package GaoQi.Utils.scannerutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerUtilsDemo3 {
    public static void main(String[] args) {
        try{
            File file=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\bufferstreamdemo22.txt");
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 创建 File 对象，表示要扫描的文件
        Scanner scanner = null; // 创建 Scanner 对象，从文件中读取数据
        try {
            scanner = new Scanner(new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\bufferstreamdemo2.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.useDelimiter("\\Z"); // 设置分隔符为文件结尾
        if (scanner.hasNext()) { // 判断文件中是否有下一行
            String content = scanner.next(); // 读取文件中的下一行
            System.out.println(content); // 打印读取的行
        }
        scanner.close(); // 关闭 Scanner 对象
    }
}
