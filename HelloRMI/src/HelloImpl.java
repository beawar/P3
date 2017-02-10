import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Bea on 09/02/2017.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello {
    public HelloImpl() throws RemoteException{}

    @Override
    public String sayHello() throws RemoteException {
        return "Hello World!";
    }
}
