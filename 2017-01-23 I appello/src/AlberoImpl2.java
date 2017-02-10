import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Bea on 09/02/2017.
 */
public class AlberoImpl2 extends UnicastRemoteObject implements Albero2 {
    private String info;
    private Albero2 figlioSin;
    private Albero2 figlioDx;

    AlberoImpl2(String s) throws RemoteException{
        info = s;
        figlioSin = new AlberoVuoto2();
        figlioDx = new AlberoVuoto2();
    }
    public AlberoImpl2(String s, Albero2 fs, Albero2 fd) throws RemoteException {
        info = s;
        figlioSin = fs;
        figlioDx = fd;
    }

    @Override
    public synchronized int nNodi() throws RemoteException {
        return figlioSin.nNodi() + figlioDx.nNodi() + 1;
    }

    @Override
    public synchronized Albero2 add(String s)  throws RemoteException {
        int ns = figlioSin.nNodi();
        int nd = figlioDx.nNodi();
        if (ns > nd){
            figlioDx = figlioDx.add(s);
        }
        else {
            figlioSin = figlioSin.add(s);
        }
        return this;
    }

    @Override
    public synchronized void stampa()  throws RemoteException{
        figlioSin.stampa();
        System.out.print(info+ " ");
        figlioDx.stampa();
    }

    @Override
    public synchronized boolean presente(String s) throws RemoteException {
        return (s.equals(info) || figlioSin.presente(s) || figlioDx.presente(s));
    }

}
