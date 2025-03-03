package it_baima_javaweb.Socket.SocketDemo7;

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
            OutputStreamWriter writer=new OutputStreamWriter(socket.getOutputStream());
            writer.write("HTTP/1.1 200 Accepeted\r\n");
            writer.write("Content-Type:text/html;charset=utf-8\r\n");
            writer.write("\r\n");
            writer.write("Tes 总冠军！");
            writer.flush();
            socket.close();

        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    }
}
