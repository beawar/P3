/**
 * Created by Bea on 06/02/2017.
 */
public class T extends Thread {
    Object lock;
    T(Object l){
        lock = l;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("pippo");
            System.out.println("pluto");
        }
    }
}
