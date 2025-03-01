package GaoQi.network;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPTest1 {

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            int port = 8888;
            System.out.println("客户端开始连接...");

            socket = new Socket(inetAddress, port);
            System.out.println("客户端连接成功！");

            os = socket.getOutputStream();
            String message = "你好，我是客户端，请多多关照";
            os.write(message.getBytes());
            System.out.println("客户端发送消息：" + message);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("客户端准备关闭连接...");
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("客户端已关闭");
        }
    }


    //服务器端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            //创建一个ServerSocket,指定端口号
            int port = 8888;
            serverSocket = new ServerSocket(port);
            System.out.println("服务器端已开启");

            socket = serverSocket.accept(); // 先接受连接
            System.out.println("收到了来自于" + socket.getInetAddress().getHostAddress() + "的连接");

            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;

            baos = new ByteArrayOutputStream();
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("\n接收数据完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
