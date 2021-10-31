import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private static String[] names = {"road","road","road"};
    private static  String[] adjs = {"3","2","1"};
    public static void main (String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(9090);
        System.out.println("server is waiting ");
        Socket client = listener.accept();
        BufferedReader in1 = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String request1 = in1.readLine();
        System.out.println(request1);

        System.out.println("server connected ");

        PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        try{
            while (true) {
                //  String request = in.readLine();
                if (request1.contains("from ")&& request1.contains("to")) {

                    Socket socket = new Socket("127.0.0.1",9091);
                    PrintWriter out2 = new PrintWriter(socket.getOutputStream(), true);
                    BufferedReader ad = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String request = ad.readLine();
                    out.println(getrandomname());
                    out2.close();
                    ad.close();


                } else {

                    out.println("write from place to place ");
                }




            }
        }finally{

            out.close();
            in1.close();


        }
    }


    public static String getrandomname(){
        String name = names[(int)(Math.random()* names.length)];
        String adj = adjs[(int)(Math.random()* adjs.length)];
        return name +" "+adj;
    }
}
