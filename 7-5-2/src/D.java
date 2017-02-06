/**
 * Created by Bea on 06/02/2017.
 */
public class D extends Thread {
    Daemon dm = new Daemon();
    private int j = 0;

    @Override
    public void run() {
        dm.start();
        while (j<100){
            ++j;
            System.out.print(dm.i + " ");
        }
    }

    public static void main(String[] args) {
        D d = new D();
        d.start();
    }
}
