import java.util.Vector;

/**
 * Created by Bea on 07/02/2017.
 */
public class TavolaCalda {
    private int prox_primo_da_servire = 0;
    private int prox_secondo_da_servire = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    Cliente[] clienti;
    private int pagato = 0;

    public void prendi_primo(int i){
        synchronized (lock1){
            synchronized (clienti[i]){
                try {
                    while (i != prox_primo_da_servire){
                        lock1.wait();
                    }
                    System.out.println("Servito primo a "+i);
                    prox_primo_da_servire++;
                    lock1.notifyAll();
                }
                catch (InterruptedException e){}
            }
        }
    }

    public void prendi_secondo(int i){
        try {
            Thread.sleep(10);
            synchronized (lock2){
                    while (i != prox_secondo_da_servire){
                        lock2.wait();
                    }
                    System.out.println("Servito secondo a "+i);
                    prox_secondo_da_servire++;
                    lock2.notifyAll();
                }

        }
        catch (InterruptedException e){}


    }

    public void paga(Cliente c){
        synchronized (lock3){
            c.pagamento();
            pagato++;
            lock3.notifyAll();
        }
    }

    private void generaClienti(final int n){
        clienti = new Cliente[n];
        new Thread(){
            @Override
            public void run() {
                for (int i=0; i<n; ++i){
                    clienti[i] = new Cliente(TavolaCalda.this);
                    clienti[i].start();
                }
            }
        }.start();

    }

    private void attendiClienti(final int n){
        try {
            synchronized (lock3) {
                while (pagato < n) {
                    lock3.wait();
                }
                System.out.println("finito di incassare");

            }
        }
        catch (InterruptedException e){}
    }

    public static void main(String[] args) {
        TavolaCalda m = new TavolaCalda();
        m.generaClienti(100);
        m.attendiClienti(100);
    }
}
