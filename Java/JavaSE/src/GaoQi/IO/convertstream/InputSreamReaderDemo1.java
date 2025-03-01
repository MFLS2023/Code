package GaoQi.IO.convertstream;

import java.io.*;

public class InputSreamReaderDemo1 {
    public static void main(String[] args) {
        try {
            InputStreamReader isr1=new InputStreamReader(new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\bufferstreamdemo2.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            InputStreamReader isr2=new InputStreamReader(new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\bufferstreamdemo22.txt"),"GbK");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String s="加吧劲，冲";
        try{
            OutputStreamWriter outUtf8=new OutputStreamWriter(new FileOutputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\inputstreamreaderdemo1.txt"),"GBK");
            outUtf8.write(s);
            outUtf8.close();

            InputStreamReader isr=new InputStreamReader(new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\inputstreamreaderdemo1.txt"),"GBK");
            int c;
            while((c=isr.read())!=-1){
                System.out.println((char)c);
            }
            isr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
