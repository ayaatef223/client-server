import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Sensor {
    private static String[] nodename = {"road","road","road"};
    private static  String[] status = {"3","2","1"};
    public static void main (String[] args) throws IOException {
        ServerSocket reciever = new ServerSocket(9091);
        System.out.println("Sensor is waiting ");
        Socket server = reciever.accept();
        System.out.println("sensor connected ");
        ServerHandler sert =new ServerHandler(server);
        sert.run();
        PrintWriter out = new PrintWriter(server.getOutputStream(),true);
        String date =(new Date()).toString();
        System.out.println("sensors finished " + date);
      //  out.println(getdata());
        server.close();
        reciever.close();

    }
    public static String getdata(){
        String name = nodename[(int)(Math.random()* nodename.length)];
        String adj = status[(int)(Math.random()* status.length)];
        return name +" "+adj;
    }


}
