/**
 * Created by Bea on 06/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        /*
        X x = new D();
        Y y = new B();
        C c = (C)x; //ClassCastException: D cannot be cast to C
        D.f(c, y);
        */
        /*
        Y y = new D();
        Y z = new C();
        D d = (D)y;
        d.f();
        C c = (C)d; //Non compila: tipi incompatibili: D cannot be converted to C
        c.f();
        */
        /*
        X x = new C();
        Y y = (Y)x;
        y.g();
        x.f();
        B b = (B)y;
        b.f(); //Non compila: non esiste f() in B
        */
        /*
        C c = new C();
        Y y = c;
        X x = (X)y;
        B b = (B)x;
        b.g(); b.h(); //Stampa B.g() B.h()
        */
        /*
        X x = new D();
        B b= (B)x;
        B b1 = new C();
        D.f(x, b); //Stampa D.g() D.g()
        D.f(x, b1); //Stampa D.g() B.g()
        */
        /*
        X x = new D();
        Y y = new B();
        ((B)y).h();
        D.f(x, y); //Stampa B.h() D.g() B.g()
        */
        /*
        X x = new D();
        B b = new C();
        B b1 = (B)x;
        ((C)b1).f(); //ClassCastException: D cannot be cast to C
        X x1 = (C)b;
        x1.f();
        */
        /*
        B b = new D();
        B b1 = new C();
        Y y = (D)b1; //ClassCastException: C cannot be cast to D
        D.f((D)b, y);
        */
        /*
        X x = new D();
        B b = new C();
        B b1 = (B)x;
        X x1 = (C)b;
        X x2 = (X)b1;
        x1.f(); x2.f(); //Stampa C.f() D.f()
        */
    }
}
