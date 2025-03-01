package GaoQi.IO.HomeWork;

import java.io.*;

public class Test1 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("D:\\Photograph\\Blog_inages\\photo-1494774157365-9e04c6720e47.webp");

        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream("D:\\Photograph\\Screenshots\\test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }

        int b;
        byte [] buffer=new byte[1024];
        while((b=fis.read(buffer))!=-1){
            try {
                fos.write(buffer,0,b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fis.close();
        fos.close();
    }
}
