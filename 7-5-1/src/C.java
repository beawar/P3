/**
 * Created by Bea on 06/02/2017.
 */
public class C {
    public static void main(String[] args) {
        T t1 = new T(1),
        t2 = new T(2);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        try {
            t1.join();
        }
        catch (InterruptedException e){return;}
        t2.start();
    }
}
