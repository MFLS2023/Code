package GaoQi.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketDemo2 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8888)) {

            while (true) {
                Socket socket = server.accept();
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            InputStream is = socket.getInputStream();
                            OutputStream os = socket.getOutputStream();
                            Scanner scanner = new Scanner(is);

                            // 其他代码省略
                            // 向客户端发送消息
                            // 读取客户端发送过来的消息
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        // 套接字处理程序
                    }
                });
                thread.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
