package GaoQi.IO.bytestream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo1 {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test.txt");
            int data;
            while((data=fis.read())!=-1){
                System.out.println((char)data);

            }
            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            FileInputStream fis1=new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream.txt");
            byte[] buffer=new byte[20];
            int count;
            while((count=fis1.read(buffer))!=-1){
                System.out.println(new String(buffer,0,count));
            }
            fis1.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
