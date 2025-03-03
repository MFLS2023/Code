package it_baima_javaweb.Socket.SocketDemo6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8087)){
            Socket socket=server.accept();
            System.out.println("客户端已连接，IP地址为:" + socket.getInetAddress().getHostAddress());
            InputStream inputStream1=socket.getInputStream();
            System.out.println("接收到客户端数据：");
            while(true){
                int i=inputStream1.read();
                if(i==-1){
                    break;
                }
                System.out.print((char)i);
            }


        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    }
}
