import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Bea on 09/02/2017.
 */
public interface C extends Remote {
    void aggiungi(I i) throws RemoteException;
    I get(int i) throws RemoteException;
    String stampa() throws RemoteException;
}
