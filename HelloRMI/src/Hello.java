import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Bea on 09/02/2017.
 */
public interface Hello extends Remote {
    public String sayHello() throws RemoteException;
}
