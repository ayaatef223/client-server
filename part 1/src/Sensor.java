//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Sensor {
    private static String[] nodename = new String[]{"road", "road", "road"};
    private static String[] status = new String[]{"3", "2", "1"};

    public Sensor() {
    }

    public static void main(String[] args) throws IOException {
        ServerSocket reciever = new ServerSocket(9091);
        System.out.println("Sensor is waiting ");
        Socket server = reciever.accept();
        System.out.println("sensor connected ");
        new PrintWriter(server.getOutputStream(), true);
        String date = (new Date()).toString();
        System.out.println("sensors finished " + date);
        server.close();
        reciever.close();
    }

    public static String getdata() {
        String name = nodename[(int)(Math.random() * (double)nodename.length)];
        String adj = status[(int)(Math.random() * (double)status.length)];
        return name + " " + adj;
    }
}
