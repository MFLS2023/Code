package GaoQi.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static java.net.InetAddress.getByName;

public class SocketDemo3 {
    public static void main(String[] args) {

        try {
            InetAddress inet1= InetAddress.getLocalHost();
            System.out.println(inet1);

            InetAddress inet2=getByName("127.0.0.1");
            System.out.println(inet2);

            InetAddress inet3=InetAddress.getByName("www.baidu.com");
            System.out.println(inet3);

            InetAddress inet4=InetAddress.getByName("129.123.45.89");
            System.out.println(inet4);

            System.out.println("主机名:"+inet3.getHostName());
            System.out.println("IP地址:"+inet3.getHostAddress());


        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}
