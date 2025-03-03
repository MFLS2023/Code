package it_baima_javaweb.Socket.SocketDemo5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8086)){
            Socket socket=server.accept();
            InputStream inputStream=socket.getInputStream();
            FileOutputStream fileOutputStream=new FileOutputStream("src/it_baima_javaweb/Socket/SocketDemo5/siniang.txt");
            byte[]bytes=new byte[1024];
            int i=0;
            while((i=inputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes,0,i);
            }
            fileOutputStream.flush();
            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    }
}
