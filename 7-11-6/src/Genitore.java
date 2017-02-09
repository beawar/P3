/**
 * Created by Bea on 08/02/2017.
 */
public class Genitore extends MembroFamiglia {
    private int figli;

    Genitore(int n){
        figli = n;
    }

    @Override
    public void run() {
        int reddito = (int) (Math.random() * 10000);
        System.out.println("Genitore");
        synchronized (getRr()) {
            while (!getRr().figliInseriti(figli)) {
                try {
                    getRr().wait();
                } catch (InterruptedException e) {
                }
            }
        }
        synchronized (getRr().lock_sconto) {
            if (!getRr().sconto) {
                System.out.println("sconto");
                getRr().sconto = true;
                reddito -= (int) (0.05 * getRr().getRedditoFigli(figli));
            }
        }
        getRr().setReddito(reddito);

    }
}
