package GaoQi.IO.filestream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        String filePath="D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test.txt";

        try {
            writeToFile(filePath,"hello world! 你好，世界！");

            String content=readFromFile(filePath);
            System.out.println("文件内容："+content);
        }catch(IOException e){
            e.printStackTrace();
        }


    }

    private static void writeToFile(String filePath, String content) throws IOException{
        try(RandomAccessFile randomAccessFile =new RandomAccessFile(filePath,"rw")){
            randomAccessFile.seek(randomAccessFile.length());
            randomAccessFile.writeUTF(content);
        }
    }

    private static String readFromFile(String filePath) throws IOException {
        StringBuilder content=new StringBuilder();

        try(RandomAccessFile randomAccessFile =new RandomAccessFile(filePath,"r")){
            randomAccessFile.seek(0);
            content.append(randomAccessFile.readUTF());
        }
        return content.toString();
    }

}
