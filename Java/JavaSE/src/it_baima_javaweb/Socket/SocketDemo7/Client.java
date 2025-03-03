package it_baima_javaweb.Socket.SocketDemo7;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket=new Socket("localhost",8085)){
            FileInputStream fileInputStream=new FileInputStream("src/it_baima_javaweb/Socket/SocketDemo5/txt.txt");
            OutputStream stream=socket.getOutputStream();
            byte[]bytes=new byte[1024];
            int i;
            while((i=fileInputStream.read(bytes))!=-1){
                stream.write(bytes,0,i);
            }
            fileInputStream.close();
            stream.flush();

        } catch (IOException e) {
            System.out.println("服务端连接失败");
            throw new RuntimeException(e);
        }


    }
}
