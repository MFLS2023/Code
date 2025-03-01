package GaoQi.Exceptions.Practice1;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Student st=new Student(30,6);

        try{
            System.out.println(st.gettotalScore());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
