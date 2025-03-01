package GaoQi.IO.basic;

import java.io.*;

public class FileDemo {

    public static void main(String[] args) throws IOException {
        int b;
        FileInputStream fis1=new FileInputStream("fis.txt");

        while((b=fis1.read())!=-1){
            System.out.println((char)b);
        }

        FileOutputStream fos=new FileOutputStream("fos.txt");
        fos.write("hello".getBytes());
        fos.close();

        FileWriter fileWriter=new FileWriter("fw.txt");
        char[]chars="hello".toCharArray();
        fileWriter.write(chars,0,chars.length);
        fis1.close();

    }

}
