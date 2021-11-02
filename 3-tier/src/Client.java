import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public  static void main (String[] args) throws IOException {

        try {
            Scanner sc =new Scanner (System.in);
            //step 1

            //step 2
            Socket c = new Socket("127.0.0.1",9099);
            //step 3
            DataOutputStream dosss=  new DataOutputStream(c.getOutputStream());
            DataInputStream disss= new DataInputStream(c.getInputStream());
            //step 4
            System.out.println("enter your live location and wait");
            System.out.print(">");
            String m = sc.nextLine();
            dosss.writeUTF( m );
            String serres= disss.readUTF();
            System.out.println(" server response : "+ serres);
            System.out.println("finished ");
            //step 5
            c.close();
            dosss.close();
            disss.close();
        }catch (IOException ex){


            System.out.println("something went wrong 2");
        }

    }

}
