package GaoQi.IO.filestream;

import java.io.File;

public class FileDemo3 {
    public static void main(String[] args) {
        File file = new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test");

// 判断文件或目录是否存在
        if (file.exists()) {
            System.out.println("文件或目录存在");
        } else {
            System.out.println("文件或目录不存在");
        }

// 判断是否是目录
        if (file.isDirectory()) {
            System.out.println("是目录");
        } else {
            System.out.println("不是目录");
        }

// 判断是否是文件
        if (file.isFile()) {
            System.out.println("是文件");
        } else {
            System.out.println("不是文件");
        }
    }
}
