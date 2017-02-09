/**
 * Created by Bea on 08/02/2017.
 */
public abstract class MembroFamiglia extends Thread {
    private RegistroRedditi rr;

    @Override
    public abstract void run();

    public synchronized void setRr(RegistroRedditi rr) {
        this.rr = rr;
    }

    public synchronized RegistroRedditi getRr() {
        return rr;
    }
}
