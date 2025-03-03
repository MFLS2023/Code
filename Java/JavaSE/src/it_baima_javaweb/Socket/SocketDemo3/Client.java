package it_baima_javaweb.Socket.SocketDemo3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket=new Socket("localhost",8081); Scanner scanner=new Scanner(System.in)){
            System.out.println("已连接到服务端");
            OutputStream stream=socket.getOutputStream();
            OutputStreamWriter writer=new OutputStreamWriter(stream);
            System.out.println("请输入要发送给服务端的内容");
            writer.write(scanner.nextLine()+"\n");
            writer.flush();
            System.out.println("数据已发送！等待服务端确认");

            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("收到服务器端响应："+reader.readLine());

        } catch (IOException e) {
            System.out.println("服务端连接失败");
            throw new RuntimeException(e);
        }


    }
}
