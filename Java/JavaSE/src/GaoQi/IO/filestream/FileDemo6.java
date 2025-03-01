package GaoQi.IO.filestream;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {
        File directory=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO");

        traverseDirectory(directory);
    }

    private static void traverseDirectory(File directory) {
        File[]filesAndDirs=directory.listFiles();

        for(File fileOrDir:filesAndDirs){
            if(fileOrDir.isFile()){
                System.out.println("    文件："+fileOrDir.getName());
            }else if(fileOrDir.isDirectory()){
                System.out.println("目录："+fileOrDir.getName());
                traverseDirectory(fileOrDir);
            }
        }
    }
}
