import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;


class ServerHandler implements Runnable {

    Socket ssh;
    public ServerHandler(Socket s) {
        this.ssh = s;
    }
    @Override
    public void run() {

        try {
            BufferedReader inputread = new BufferedReader(new InputStreamReader(ssh.getInputStream()));
            String sensorResponse = inputread.readLine();
            String roads = Sensor.getdata();
            //System.out.println(Sensor.getdata());
            System.out.println(Server.bestroad());
            //JOptionPane.showMessageDialog(null,sensorResponse);

            ssh.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

public class Sensor_threaded {

    public static void main(String[] args) throws IOException {
        try {

            ServerSocket socket1 = new ServerSocket(9091);
            System.out.println("sensor is waiting ");
            while (true) {

                Socket se = socket1.accept();
                System.out.println("server Accepted...");
                PrintWriter out = new PrintWriter(se.getOutputStream(), true);
                String date = (new Date()).toString();
                System.out.println("sensors finished " + date);
                ServerHandler sh = new ServerHandler(se);
                Thread t = new Thread(sh);
                t.start();

                //  out.println(getdata());
                se.close();
                se.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }}
