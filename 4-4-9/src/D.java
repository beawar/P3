/**
 * Created by Bea on 06/02/2017.
 */
public class D extends A {
    public static B st = new B();

    @Override
    public void f() {
        System.out.println("D.f()");
    }

    @Override
    public B f(B ref) {
        if (ref instanceof A)
            return (D)ref;
        return st;
    }
}
