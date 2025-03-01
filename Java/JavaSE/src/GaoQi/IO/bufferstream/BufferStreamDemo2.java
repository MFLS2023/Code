package GaoQi.IO.bufferstream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferStreamDemo2 {
    public static void main(String[] args) {

        File file1=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\bufferstreamdemo2.txt");
        FileWriter fw1=null;
        try {
            fw1=new FileWriter(file1);
            fw1.write(100);
            fw1.write(0);
            fw1.write(20);
            fw1.write(21);
            fw1.write(65);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            if(fw1!=null){
                try {
                    fw1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        try(FileWriter fw2=new FileWriter("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\bufferstreamdemo22.txt")) {
            char[]chars={'n','i',',','y','i',',','d','i','n',',','y','a','o',',','y','i','n','g'};
            fw2.write(chars,0,chars.length);

            String str="一定会赢的，";
            fw2.write(str);

            String str1="包赢的哥们66666666666666666";
            fw2.write(str1,0,10);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
