import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Bea on 09/02/2017.
 */
public interface Albero2 extends Remote {
    Albero2 add(String s) throws RemoteException; //ritorna l'albero con un nodo in pi' con s nel campo info
    void stampa()  throws RemoteException; //stampa inline dell'albero
    boolean presente(String s) throws RemoteException; //ritorna true se e' presente in un nodo
    int nNodi() throws RemoteException; //numero di nodi, cioe' di stringhe, contenuti nell'albero
}
