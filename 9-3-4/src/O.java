import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Bea on 10/02/2017.
 */
public class O extends UnicastRemoteObject implements X{
    private D d;
    O() throws RemoteException { d = new D();}

    @Override
    public C m() throws RemoteException {
        return d;
    }

    public String n() throws RemoteException { return "ROSSO";}

    public void k(C c) throws RemoteException{
        System.out.println(c);
        c.g();
        System.out.println(c);
    }
}
