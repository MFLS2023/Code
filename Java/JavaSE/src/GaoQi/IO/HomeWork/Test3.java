package GaoQi.IO.HomeWork;

import java.io.*;

public class Test3 {
    public static void main(String[] args) {
        // 声明流对象
        FileOutputStream fos1 = null;
        FileOutputStream fos2 = null;
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;
        FileOutputStream fos3 = null;

        try {
            // 创建第一个文件并写入内容
            fos1 = new FileOutputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\HomeWork\\Demo1.txt");
            fos1.write("hello".getBytes());

            // 创建第二个文件并写入内容
            fos2 = new FileOutputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\HomeWork\\Demo2.txt");
            fos2.write("Neuedu".getBytes());

            // 读取两个文件并写入第三个文件
            fis1 = new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\HomeWork\\Demo1.txt");
            fis2 = new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\HomeWork\\Demo2.txt");
            fos3 = new FileOutputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\HomeWork\\Demo3.txt");

            // 读取并写入第一个文件内容
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis1.read(buffer)) != -1) {
                fos3.write(buffer, 0, len);
            }

            // 读取并写入第二个文件内容
            while ((len = fis2.read(buffer)) != -1) {
                fos3.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭所有流
            try {
                if (fos1 != null) fos1.close();
                if (fos2 != null) fos2.close();
                if (fis1 != null) fis1.close();
                if (fis2 != null) fis2.close();
                if (fos3 != null) fos3.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
