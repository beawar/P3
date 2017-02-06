/**
 * Created by Bea on 06/02/2017.
 */
abstract class A extends B implements X{
    @Override
    public void f() {
        System.out.println("A.f()");
    }

    @Override
    public void g() {
        System.out.println("A.g()");
    }
    public abstract B f(B ref);
}
