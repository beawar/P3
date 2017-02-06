/**
 * Created by Bea on 06/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        T t1 = new T(lock);
        T t2 = new T(lock);
        t1.start();
        t2.start();
    }
}
