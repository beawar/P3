import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Bea on 10/02/2017.
 */
public interface X extends Remote{
    public C m() throws RemoteException;
    public void k(C c) throws RemoteException;
}
