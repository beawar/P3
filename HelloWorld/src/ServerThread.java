import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Bea on 09/02/2017.
 */
public class ServerThread extends Thread {
    private Socket socket = null;

    public ServerThread(Socket s){
        super("ServerThread");
        socket = s;
    }

    @Override
    public void run() {
        try{
            OutputStream o = socket.getOutputStream();
            PrintWriter output = new PrintWriter(o, true);
            InputStream i = socket.getInputStream();
            Scanner input = new Scanner(i);

            // spedisce un dato
            output.println("Ciao caro client!");
            //legge un dato
            String dato = input.next();
            // elabora il dato
            System.out.println(dato);
        }
        catch (IOException e){
            System.err.println("I/O Exceprion");
        }
        finally {
            try{
                socket.close();
            }
            catch (IOException e){
                System.err.println("Something went wrong");
                System.exit(0);
            }
        }
    }
}
