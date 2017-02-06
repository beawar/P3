/**
 * Created by Bea on 06/02/2017.
 */
public class D {
    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        T1 t1 = new T1(b, c);
        T2 t2 = new T2(b, c);
        t1.start();
        t2.start();
    }
}
