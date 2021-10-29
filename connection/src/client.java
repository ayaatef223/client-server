import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class client {



public static void main(String[] args) throws IOException {
    Socket socket2 = new Socket("127.0.0.1", 9092);

    BufferedReader inputreadc = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(socket2.getOutputStream(),true);

    while (true) {
        System.out.println("enter your live location and wait");
        System.out.print(">");

        String command = keyboard.readLine();
        if (command.equals("quit"))break;
        out.println(command);
        System.out.println("enter your destination");
        System.out.print(">");
        String command2 = keyboard.readLine();

        if (command2.equals("quit"))break;
        String serverresponse = inputreadc.readLine();
        System.out.println("server say" + serverresponse);
        System.out.println("finished");
        break ;
    }
    socket2.close();
    System.exit(0);




}
}