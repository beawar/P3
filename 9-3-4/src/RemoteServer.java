import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Bea on 10/02/2017.
 */
public class RemoteServer {
    public static void main(String[] args) throws Exception {
        X x = new O();
        LocateRegistry.createRegistry(1099);
        Naming.rebind("pippo", x);

        System.out.println("1s: "+x.m());

        //Punto di synch 1
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e){}
        C c = x.m();
        c.f();
        System.out.println("4s: "+c);
        System.out.println("5s: "+x.m());
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){}
        //Punto di synch 2
        //System.out.println("6s: "+x.n()); Errore di compilazione
        System.out.println("7s: "+((O)x).n() );
        //System.out.println("8s: "+(X)(x.m()) ); Eccezione ClassCast
        //System.out.println("9s: "+(O)(x.m()) ); Errore di compilazione
        //System.out.println("10s: "+((X)x).n() ); Errore di compilazione

        D dd = (D)(x.m());
        dd.h();
        System.out.println("13s: "+ (C)dd);

    }
}
