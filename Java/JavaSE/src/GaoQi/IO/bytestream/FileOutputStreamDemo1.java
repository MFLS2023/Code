package GaoQi.IO.bytestream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws IOException {

        FileOutputStream fos;
        try {
             fos = new FileOutputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream1.txt");
             fos.write(85);

             byte[]b=" ->  bu shi ge men\n".getBytes();
             fos.write(b);
             fos.write("-> bbbbbb\\n\n ".getBytes());

             byte[]b1="\\r-> zhi  you \r".getBytes();
             fos.write(b1,0,10);

             String fileName="D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream1.txt";
            try(FileOutputStream fos1=new FileOutputStream(fileName,true)){
                fos1.write("-> first:test\\r".getBytes());
            }catch (IOException e){
                e.printStackTrace();
            }

            File file=new File(fileName);
            try(FileOutputStream fos2=new FileOutputStream(file,true)){
                fos2.write("-> second:test\r\n\\r\\n".getBytes());
            }catch (IOException e){
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
