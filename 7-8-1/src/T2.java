/**
 * Created by Bea on 07/02/2017.
 */
public class T2 extends Thread {
    boolean sospendi = false;

    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    while (sospendi) {
                        wait();
                    }
                    System.out.println("topolino");
                }
                Thread.sleep((int) Math.random() * 80);
            } catch (InterruptedException e) {
                System.out.println("Eccezione");
            }
        }
    }
}
