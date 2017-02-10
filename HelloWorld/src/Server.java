import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Bea on 09/02/2017.
 */
public class Server {
    private int port = 1234;
    private ServerSocket serverSocket = null;
    public void activate() throws IOException{
        try {
            //Crea un server che accetta connesioni
            serverSocket = new ServerSocket(port);
        }
        catch (IOException e){
            System.err.println("Could not listen on port "+port );
            System.exit(1);
        }
        //Rimane in attesa di connessioni
        while (true){
            Socket s1 = serverSocket.accept();
            ServerThread serverThread = new ServerThread(s1);
            serverThread.start();
        }

    }

    public static void main(String[] args) throws IOException{
        Server s = new Server();
        s.activate();
    }

}
