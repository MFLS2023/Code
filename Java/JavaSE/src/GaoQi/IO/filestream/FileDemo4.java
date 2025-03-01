package GaoQi.IO.filestream;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileDemo4 {
    public static void main(String[] args) {

        System.out.println("1111111111");
        File file=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test");
        try {
            if(file.createNewFile()){
                System.out.println("创建文件成功 "+file.getAbsolutePath());
            }else{
                System.out.println("文件已存在 "+file.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(file.delete()){
            System.out.println("文件删除成功 "+file.getAbsolutePath());
        }else{
            System.out.println("文件删除失败 "+file.getAbsolutePath());
        }


        System.out.println("22222222222222222222");
        File directory=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test");
        if(directory.mkdir()){
            System.out.println("创建目录成功 "+directory.getAbsolutePath());
        }else{
            System.out.println("目录已存在 "+directory.getAbsolutePath());
        }


        System.out.println("333333333333333333333");
        File newfile=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test\\test.txt");
        try{
            if(newfile.createNewFile()){
                System.out.println("创建文件成功 "+newfile.getAbsolutePath());

            }else{
                System.out.println("文件已存在 "+newfile.getAbsolutePath());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        }


        System.out.println("44444444444444444444444");

        File directory1=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test\\test");
        if(directory1.mkdirs()){
            System.out.println("创建目录成功 "+directory1.getAbsolutePath());
        }else{
            System.out.println("目录已存在 "+directory1.getAbsolutePath());
        }

        if(directory1.delete()){
            System.out.println("文件删除成功 "+directory1.getAbsolutePath());
        }else{
            System.out.println("文件删除失败 "+directory1.getAbsolutePath());
        }
    }
}
