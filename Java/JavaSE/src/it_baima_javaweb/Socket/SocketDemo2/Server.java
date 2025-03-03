package it_baima_javaweb.Socket.SocketDemo2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8081)){
            System.out.println("正在等待客户端连接");
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为:" + socket.getInetAddress().getHostAddress());
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("已接受到客户端发来的数据：");
            System.out.println(reader.readLine());
            //socket.close();
        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    }
}
