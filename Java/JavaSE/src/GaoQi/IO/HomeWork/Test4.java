package GaoQi.IO.HomeWork;

import java.io.File;

public class Test4 {
    public static void main(String[] args) {

        File file=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO");
        for(File file1:file.listFiles()){
            if(file1.isDirectory()){
                System.out.println("路径是"+file1.getAbsolutePath()+"的文件夹内有：");
            }else if(file1.isFile()){
                System.out.println(" 文件名："+file1.getName());
                System.out.println(" 路径名："+file1.getAbsolutePath());
                System.out.println("-----------------------------------------");
            }
        }

    }
}
