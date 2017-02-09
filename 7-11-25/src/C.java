/**
 * Created by Bea on 09/02/2017.
 */
public class C {
    public static void main(String[] args) {
        Z z = new Z();
        T t1 = new T(z),
        t2 = new T(z);

        t1.start(); t2.start();
    }
}
