import java.rmi.RemoteException;

/**
 * Created by Bea on 09/02/2017.
 */
public class AlberoVuoto2 implements Albero2 {
    public Albero2 add(String s) throws RemoteException{
        return new AlberoImpl2(s, new AlberoVuoto2(), new AlberoVuoto2());
    }

    public void stampa(){
        System.out.print("- ");
    }

    @Override
    public boolean presente(String s) {
        return false;
    }

    @Override
    public int nNodi() {
        return 0;
    }
}
