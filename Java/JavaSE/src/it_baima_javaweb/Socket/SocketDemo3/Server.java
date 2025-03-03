package it_baima_javaweb.Socket.SocketDemo3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8081)){
            System.out.println("正在等待客户端连接");
            Socket socket = server.accept();
            System.out.println("客户端已连接，IP地址为:" + socket.getInetAddress().getHostAddress());
            System.out.println("读取客户端数据：");
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(reader.readLine());

            OutputStreamWriter writer=new OutputStreamWriter(socket.getOutputStream());
            writer.write("收到\n");
            writer.flush();
            socket.close();
        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    }
}
