package GaoQi.network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPTest3 {
    @Test
    public void cilent() throws IOException {
        //1. 创建Socket
        InetAddress inetAddress=InetAddress.getByName("127.0.0.1");
        int port=9090;
        Socket socket=new Socket(inetAddress,port);
        //2. 创建File的实例、FileInputStream的实例
        File file = new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream1.txt");
        FileInputStream fis = new FileInputStream(file);

        //3. 通过Socket、获取输出流
        OutputStream os = socket.getOutputStream();

        //4. 读写数据
        byte[]buffer=new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }


        System.out.println("数据发送完毕");

        //5. 接收来自于服务端的数据
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while((len=is.read(buffer))!=-1){
            baos.write(buffer,0,len);
        }
        System.out.println(baos.toString());
        System.out.println("\n接收数据完毕");

        //6. 关闭Socket和相关的流
        baos.close();
        is.close();
        os.close();
        fis.close();
        socket.close();
    }


    @Test
    public void server() throws IOException {
        //1. 创建ServerSocket
        int port=9090;
        ServerSocket serverSocket = new ServerSocket(port);
        //2. 接收来自于客户端的socket:accept()
        Socket socket = serverSocket.accept();
        //3. 通过Socket获取一个输入流
        InputStream is=socket.getInputStream();
        //4. 创建File类的实例、FileOutputStream的实例
        File file=new File("D:\\study\\Code\\Java\\JavaSE\\src\\GaoQi\\IO\\fileoutputstream2.txt");
        FileOutputStream fos=new FileOutputStream(file);
        //5. 读写过程
        byte[]buffer=new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        System.out.println("数据接收完毕");
        socket.shutdownOutput();

        //6.服务器发送数据给客户端
        OutputStream os=socket.getOutputStream();
        String message="你的图片非常好，很喜欢！";
        os.write(message.getBytes());
        //7. 关闭相关的Socket和流
        os.close();
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }

}
