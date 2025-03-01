package GaoQi.IO.bytestream;


import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[] args) {

        String fileName="D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream.txt";
        FileOutputStream fos=null;
        try {
            fos=new FileOutputStream(fileName);
            fos.write("hello world".getBytes());

            fos.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                     e.printStackTrace();
                }
            }
        }

    }
}
