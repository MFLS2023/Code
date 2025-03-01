package GaoQi.IO.filestream;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        String path="D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO";
        File file1=new File(path);

        String path2="D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test\\test.txt";
        File file2=new File(path2);

        System.out.println(file1.exists());
        System.out.println(file2.exists());

        String parent="D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO";
        String child="test3";

        File file3=new File(parent,child);
        File parentDir=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO");
        String child2="test33";
        File file4=new File(parentDir,child2);
        System.out.println(file3.exists());
        System.out.println(file4.exists());

    }
}
