import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class client {
    public static void main (String[] args) throws Exception{

        Socket socket = new Socket("127.0.0.1",9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

        while (true) {
            System.out.println("enter your live location and wait");
            System.out.println(">");


            String command = keyboard.readLine();
            if (command.equals("quit"))break;
            out.println(command);


            String serverresponse = input.readLine();
            System.out.println("server say" + serverresponse);

        }
        socket.close();
        System.exit(0);




    }
}
