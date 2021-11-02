import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class computersHandler implements Runnable
{ Socket c;
public computersHandler(Socket c){
    this.c =c;
}
    @Override
    public void run() {
        try{
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
            //master.close();


        }catch (Exception a){
            System.out.println("something went wrong");
        }
    }
}




public class Server {


    public  static void main (String[] args) {

        try {
            //step 1
            System.out.println("server is waiting ");
            ServerSocket master = new ServerSocket(9098);
            while (true) {
                //step 2
                Socket c = master.accept();
                System.out.println("server connected ");
                //step 3
                computersHandler ch = new computersHandler(c);
                Thread t = new Thread(ch);
                t.start();
            }
        }catch (IOException ex){


            System.out.println("something went wrong ");
        }

    }

}
