package it_baima_javaweb.Socket.SocketDemo4;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket=new Socket();Scanner scanner=new Scanner(System.in)){
            socket.connect(new InetSocketAddress("localhost",8081),10);
            socket.setKeepAlive(true);
            System.out.println("已连接到服务端");
            OutputStream stream=socket.getOutputStream();
            OutputStreamWriter writer=new OutputStreamWriter(stream);
            System.out.println("请输入要发送给服务端的内容");
            writer.write(scanner.nextLine()+"\n");
            writer.flush();
            System.out.println("数据已发送！等待服务端确认");
            socket.shutdownOutput();//提前关闭输出流

            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("收到服务器端响应："+reader.readLine());
            socket.shutdownInput();//提前关闭输入流

        } catch (IOException e) {
            System.out.println("服务端连接失败");
            throw new RuntimeException(e);
        }


    }
}
