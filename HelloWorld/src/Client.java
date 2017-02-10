import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Bea on 09/02/2017.
 */
public class Client {
    private Socket s = null;
    private InetAddress ip;
    private int port = 1234;

    public void go() throws IOException {
        // Localhost
        ip = InetAddress.getByName("127.0.0.1");
        // tenta la connesione al server
        s = new Socket(ip, port);
        try {
            Scanner input = new Scanner(s.getInputStream());
            OutputStream o = s.getOutputStream();
            PrintWriter output = new PrintWriter(o, true);
            // legge un dato
            String dato = input.next();
            //elabora il dato
            System.out.println(dato);
            System.out.println("Premi Enter per mandare la ricevuta");
            new Scanner(System.in).next();
            // manda un dato
            output.println("ricevuto!");
        } finally {
            //chiude sempre la connessione ed esce
            s.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
        c.go();
    }
}
