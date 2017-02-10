import java.rmi.ConnectException;
import java.rmi.Naming;

/**
 * Created by Bea on 09/02/2017.
 */
public class HelloClient {
    private static final String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        try {
            // ottieni istanta di oggetto remoto (di tipo giusto)
            Hello ref = (Hello) Naming.lookup("rmi://"+HOST+"/Hello");
            // invoca il metodo remoto
            System.out.println("messaggio ricevuto: "+ref.sayHello());
        }
        catch (ConnectException e){
            System.out.println("problemi di connessione al server");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
