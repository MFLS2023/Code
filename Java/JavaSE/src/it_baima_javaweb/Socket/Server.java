package it_baima_javaweb.Socket;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        {
            try {
                ServerSocket server = new ServerSocket(8888);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
