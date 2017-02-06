/**
 * Created by Bea on 06/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        /*
        X x = new D();
        C c = x; //Non compila: X cannot be converted to C
        x.f();
        */
        /*
        X x = new F();
        Y y = x; //Non compila: X cannot be converted to Y
        y.g();
        */
        /*
        X x = new C();
        Y y = (C)x; //Non compila: C cannot be converted to Y
        y.g();
        */
        /*
        Y y = new E();
        D d = (D)y;
        d.f(); y.g(); //Stampa C.f() E.g()
        */
        /*
        Y y = new D();
        X x = (E)y;
        x.f(); y.g(); //ClassCastException: D cannot be cast to E
        */
        /*
        Y y = new D();
        X x = (D)y;
        ((E)x).g(); //ClassCastException: D cannot be cast to E
        */
        /*
        C c = new D();
        X x = (D)c;
        Y y = (D)x;
        y.g(); x.f(); //Stampa D.g() C.f()
        */
        /*
        C c = new E();
        Y y = (D)c;
        ((E)c).f();
        y.f(); //Non compila : non esiste f() in Y
        */
    }
}
