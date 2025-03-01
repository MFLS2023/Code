package GaoQi.Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class CheckedException {
    public static void main(String[] args) throws IOException {
        readMyfile();
        readMyfile1();

    }

    private static void readMyfile() {
        FileReader reader=null;
        try{
            reader =new FileReader("d:/a.txt");
            char c1=(char)reader.read();
            char c2=(char)reader.read();
            System.out.println(""+c1+c2);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(reader !=null){
                    reader.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }


    public static void readMyfile1 ()throws IOException {
        FileReader reader=null;
        reader = new FileReader("d:/a.txt");
        System.out.println("step1");
        char c1=(char)reader.read();
        System.out.println("step2");
    }
}


