import com.sun.deploy.util.SyncAccess;
import sun.misc.Lock;

import java.util.Random;
import java.util.Vector;

/**
 * Created by Bea on 07/02/2017.
 */
public class Controllore extends Thread {
    private Vector<Aereo> coda_arrivi = new Vector<Aereo>();
    private Vector<Aereo> coda_partenze = new Vector<Aereo>();
    private TS ritardi = new TS(new Vector<Aereo>());
    private static final Object lock_arrivi = new Object();
    private static final Object lock_partenze = new Object();
    private static final Object lock_pista = new Object();
    private static final Object lock_ritardi = new Object();

    Controllore(){
        super("Controllore");
    }

    public void add_arrivi(Aereo a){
        synchronized (lock_arrivi){
            coda_arrivi.add(a);
        }
    }

    public void add_partenze(Aereo a){
        synchronized (lock_partenze){
            coda_partenze.add(a);
        }

    }

    private char prox_transito(){
        // il metodo consulta la tabella oraria e
        // restituisce 'A' o 'P' indicando se assegnare la pista
        // ad un aereo in arrivo o in partenza
        Random rand = new Random();
        if (rand.nextBoolean()){
            return 'A';
        }
        else return 'P';
    }

    @Override
    public void run() {
        while (true){
            char c = prox_transito();
            if (c == 'A'){
               // System.out.println("In arrivo");
                gestisci_arrivo();
            }
            else{
                //System.out.println("In partenza");
                gestisci_partenza();
            }
        }
    }

    private void gestisci_arrivo(){
        if (!ritardi.ritardo_arrivo) {
            synchronized (lock_arrivi) {
                if (!coda_arrivi.isEmpty()) {
                    Aereo a = coda_arrivi.remove(0);
                    synchronized (lock_pista) {
                        a.stampa();
                    }
                } else {
                    ritardi.ritardo_arrivo = true;
                    synchronized (ritardi) {
                        ritardi.notify();
                    }
                }
            }
        }
    }

    private void gestisci_partenza(){
        if (!ritardi.ritardo_partenza){
            synchronized (lock_partenze) {
                if (!coda_partenze.isEmpty()) {
                    Aereo a = coda_partenze.remove(0);
                    synchronized (lock_pista) {
                        a.stampa();
                    }
                } else {
                    ritardi.ritardo_partenza = true;
                    synchronized (ritardi) {
                        ritardi.notify();
                    }
                }
            }
        }
    }

    private class TS extends Thread{
        Vector<Aereo> coda;
        boolean ritardo_arrivo = false, ritardo_partenza = false;
        Thread wait_arrivi = new Thread("wait_arrivi") {
            @Override
            public void run() {
                synchronized (this){
                    try {
                        wait();
                    }
                    catch (InterruptedException e){}
                }
                if (!coda_arrivi.isEmpty()) {
                    System.out.println("wait arrivi");
                    synchronized (lock_arrivi) {
                        synchronized (lock_ritardi) {
                            coda.add(coda_arrivi.remove(0));
                            ritardo_arrivo = false;
                        }
                    }
                }
            }
        };

        Thread wait_partenze = new Thread("wait_partenze"){
            @Override
            public void run() {
                synchronized (this){
                    try {
                        wait();
                    }
                    catch (InterruptedException e){}
                    synchronized (lock_partenze){
                        if (!coda_partenze.isEmpty()){
                            System.out.println("wait partenze");

                            synchronized (lock_ritardi){
                                coda.add(coda_partenze.remove(0));
                                ritardo_partenza = false;
                            }
                        }
                    }
                }
            }
        };

        TS(Vector<Aereo> s){
            super("TS");
            coda = s;
            wait_arrivi.start();
            wait_partenze.start();
        }

        @Override
        public void run() {
            synchronized (this){
                try {
                    wait();
                }
                catch (InterruptedException e){}
                if (ritardo_arrivo){
                    synchronized (wait_arrivi){
                        wait_arrivi.notify();
                    }
                }
                if (ritardo_partenza){
                    synchronized (wait_partenze){
                        wait_partenze.notify();
                    }
                }
                synchronized (lock_ritardi){
                    if (!coda.isEmpty()) {
                        Aereo a = coda.remove(0);
                        synchronized (lock_pista) {
                            System.out.println("Ritardo");
                            a.stampa();
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Controllore controllore = new Controllore();
        GeneraArrivi ga = new GeneraArrivi(controllore);
        GeneraPartenze gp = new GeneraPartenze(controllore);
        ga.start();
        gp.start();
        controllore.start();
    }
}
