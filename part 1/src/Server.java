//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
    }

    public static void main(String[] args) throws IOException {
        Socket socket1 = new Socket("127.0.0.1", 9091);
        ServerSocket socket2 = new ServerSocket(9092);
        BufferedReader inputread = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        String sensorResponse = inputread.readLine();
        String roads = Sensor.getdata();
        System.out.println(bestroad());
        socket1.close();
        System.out.println("server is waiting ");
        Socket client = socket2.accept();
        System.out.println("client connected ");
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

        try {
            while(true) {
                while(true) {
                    String request = in.readLine();
                    if (request.contains("from ")) {
                        out.println(bestroad());
                    } else {
                        out.println("write from place to place ");
                    }
                }
            }
        } finally {
            out.close();
            in.close();
        }
    }

    public static String bestroad() {
        return Sensor.getdata();
    }
}