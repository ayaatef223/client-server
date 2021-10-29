import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

 class ClientHandler implements Runnable {
     Socket s;

     public ClientHandler(Socket s) {
         this.s = s;
     }

     @Override
     public void run() {
         try {
             BufferedReader inputreadc = new BufferedReader(new InputStreamReader(s.getInputStream()));
             BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

             while (true) {


                 String command = keyboard.readLine();
                 if (command.equals("quit")) break;
                 out.println(command);
                 out.println("enter your destination");
                 out.println(">");
                 String command2 = keyboard.readLine();
                 if (command2.equals("quit")) break;
                 String serverresponse = inputreadc.readLine();
                 out.println("server say" + serverresponse);

             }
             s.close();
             System.exit(0);


         } catch (IOException e) {
             out.println(e.getMessage());
         }
     }
 }

public class server_threaded {

    public static void main(String[] args) throws IOException {
        try {
            ServerSocket socket2 = new ServerSocket(9092);
            Socket sclient = new Socket ("127.0.0.1", 9091);

            BufferedReader inputread = new BufferedReader(new InputStreamReader(sclient.getInputStream()));
            String sensorResponse = inputread.readLine();
            String roads = Sensor.getdata();
            //System.out.println(Sensor.getdata());
            System.out.println(Server.bestroad());
            //JOptionPane.showMessageDialog(null,sensorResponse);

            sclient.close();



            System.out.println("server is waiting ");
            while (true) {

                Socket s = socket2.accept();
                System.out.println("Client Accepted...");
                PrintWriter out = new PrintWriter(s.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                System.out.println("finished...");
                ClientHandler ch = new ClientHandler(s);
                Thread t = new Thread(ch);
                t.start();
                String request = in.readLine();
                if (request.contains("from ")) {
                    out.println(Server.bestroad());
                } else {

                    out.println("write from place to place ");
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

}
 }