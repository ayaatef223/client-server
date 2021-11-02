import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public  static void main (String[] args) {

        try {
            //step 1
            System.out.println("server is waiting ");
            ServerSocket master = new ServerSocket(9098);

            //step 2
            Socket c = master.accept();

            //step 3
            DataOutputStream dos=  new DataOutputStream(c.getOutputStream());
            DataInputStream dis= new DataInputStream(c.getInputStream());
            //step 4
            String clientres= dis.readUTF();
            System.out.println("server recieves the request :  ");
System.out.println(clientres);
            dos.writeUTF("road 1");
            System.out.println("server send the recommenadtion succesfully");
            //step 5
            c.close();
            dos.close();
            dis.close();
            master.close();
        }catch (IOException ex){


            System.out.println("something went wrong ");
        }

    }

}
