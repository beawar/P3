import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Bea on 09/02/2017.
 */
public class HelloServer {
    private static final String HOST = "localhost";

    public static void main(String[] args) throws Exception {
        // crea istanza di oggetto remoto
        HelloImpl ref = new HelloImpl();
        //genera un nome con cui pubblicizzare l'oggetto
        String rmiObjName = "rmi://"+HOST+"/Hello";
        // registra l'oggetto con il suo nome nell'rmi registry
        LocateRegistry.createRegistry(1099);
        Naming.rebind(rmiObjName, ref);
        System.out.println("Server pronto");
    }
}
