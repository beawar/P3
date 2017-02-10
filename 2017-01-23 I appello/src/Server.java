import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Bea on 10/02/2017.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        try {

            Albero2 a = new AlberoImpl2("pippo");
            a.add("pluto").add("paperino").add("minnie").
                    add("topolino").add("gastone").add("paperone");
            a.stampa(); //- minnie - pluto - gastone - pippo - topolino - paperino -paperone -

            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/Albero", a);

            //*****************************
            //*          Punto C          *
            //*****************************

            try {
                //per testare esecuzioni diverse
                Thread.sleep((int)Math.random()*5000 + 1000);
                a.add("qui");

                Thread.sleep((int) (Math.random() * 10));
                a.add("quo");
                System.out.println();
                a.stampa();
            } catch (RemoteException e) {
                System.out.println("Errore2");
            }
            catch (InterruptedException e){
                System.out.println("InterruptedS");
            }

        } catch (RemoteException e) {
            System.out.println("Errore3");
        }
    }

}
