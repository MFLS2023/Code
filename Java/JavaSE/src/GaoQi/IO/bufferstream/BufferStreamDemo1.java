package GaoQi.IO.bufferstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferStreamDemo1 {
    public static void main(String[] args) {
        try {
            FileReader fr=new FileReader("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream.txt");
            int b;
            while((b=fr.read())!=-1){
                System.out.println((char)(b));
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File textFile=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream1.txt");
        try{
            FileReader reader=new FileReader(textFile);
            char[]buffer=new char[1024];
            int len;
            while((len=reader.read(buffer,0,buffer.length))!=-1){
                System.out.print(new String(buffer,0,len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
