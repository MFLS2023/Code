package GaoQi.IO.convertstream;
import java.io.*;

public class OutputStreamWriterDemo1 {
    public static void main(String[] args) {


        try {
            FileInputStream fis = new FileInputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test.txt");

            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(isr);

            FileOutputStream fos = new FileOutputStream("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\test1.txt");

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

            BufferedWriter bw = new BufferedWriter(osw);

            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
