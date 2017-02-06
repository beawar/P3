/**
 * Created by Bea on 06/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        /*
        B b = new A(); A is abstract; cannot be instantiated
        X x = (A)b;
        x.f();
        */
/*
        A a = new D();
        B b = a;
        b.g(); //Stampa A.g()
        a.g(); //Stampa A.g()
        a.f(b);
*/
/*
        B b = new D();
        A a1 = (A)b;
        A a2 = (D)b;
        a1.f(); //Stampa D.f()
        a2.f(); //Stampa D.f()
*/
/*
        D d = new D();
        B b1 = d;
        B b2 = d.f(b1);
        b2.g(); //Stampa A.g()
*/
/*
        B b1 = new B();
        A a = new D();
        B b2 = a.f(b1);
        X x = (D)b2; //ClassCastException: B cannot be cast to D
*/
/*
        X x = new C();
        C c = (C)x;
        B b = new D();
        c.f(b); //Stampa C.f(Object)
*/
/*
        X x = new C();
        B b = new B();
        x.f(b); //Non compila, non esite il metodo f(qualcosa) nell'interfaccia X
*/
/*
        A a = new D();
        C c = (C)(a.f(a)); //ClassCastException: D cannot be cast to C
*/
    }
}
