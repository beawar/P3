/**
 * Created by Bea on 07/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        Object lock1 = new Object(),
                lock2 = new Object();
        T t = new T(lock1, lock2);
        t.start();
        synchronized (t){
                for (int i=0; i<10000; i++){
                    if (i%4 == 0){
                        t.notify();
                    }
                }


        }
    }
}
