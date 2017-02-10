import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Bea on 09/02/2017.
 */
public class CImpl extends UnicastRemoteObject implements C {
    private I[] v = new I[10];
    private int top = 0;

    CImpl() throws RemoteException {}

    @Override
    public synchronized void aggiungi(I i) throws RemoteException {
        v[top++] = i;
        if (top == v.length){
            I[] temp = new I[v.length*2];
            for (int j = 0; j < top; ++j){
                temp[j] = v[j];
            }
            v = temp;
        }

    }

    @Override
    public synchronized I get(int i) throws RemoteException {
        for (int j = 0; j<top; ++j){
            if (v[j].get() == i){
                return v[j];
            }
        }
        return null;
    }

    public synchronized void incrementa(int n){
        for (int j=0; j<top; ++j){
            v[j].set(v[j].get()+n);
        }
    }

    public synchronized String stampa(){
        String s = "";
        for (int j=0; j<top; ++j){
            s+=v[j].get()+" ";
        }
        return s;
    }
}
