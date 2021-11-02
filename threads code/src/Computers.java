import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class clientsHandler implements Runnable
{ Socket s;
    public clientsHandler(Socket s){
        this.s =s;
    }
    @Override
    public void run() {
        try{
            DataOutputStream doss=  new DataOutputStream(s.getOutputStream());
            DataInputStream diss= new DataInputStream(s.getInputStream());
            //step 4
            String clientres= diss.readUTF();
            System.out.println("computer recieves the request : ");
            System.out.println(clientres);
            System.out.println("waiting the server recommendation ");
            //
            if (clientres.contains("from ")&& clientres.contains("to")){
                Socket c = new Socket("127.0.0.1",9098);

                DataOutputStream dos=  new DataOutputStream(c.getOutputStream());
                DataInputStream dis= new DataInputStream(c.getInputStream());
                dos.writeUTF( clientres );
                String serres= dis.readUTF();
                System.out.println(serres);
                doss.writeUTF( serres );

                dos.close();
                dis.close();
                c.close();
                System.out.println("computer send the recommenadtion succesfully");
            }
            else {
                System.out.println(clientres);



            }



            //step 5
            s.close();
            //master.close();
            doss.close();
            diss.close();


        }catch (Exception a){
            System.out.println("something went wrong");
        }
    }
}





public class Computers {


    public  static void main (String[] args) throws IOException {

        try {
            //step 1
            System.out.println("computer is waiting ");
            //step 2
            ServerSocket master = new ServerSocket(9099);
            while (true) {
                Socket s = master.accept();
                //step 3


                System.out.println("copmuter  connected ");
                //step 3
                clientsHandler ch = new clientsHandler(s);
                Thread t = new Thread(ch);
                t.start();

            }

        }catch (IOException ex){


            System.out.println("something went wrong ");
        }

    }

}



