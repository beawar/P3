/**
 * Created by Bea on 06/02/2017.
 */
public class main {
    public static void main(String[] args) {
        A ref1 = new B();
        A ref2 = new D();
        B ref3= new B();
        C ref4 = new C();
        C ref5 = new D();
        Object ref6 = new C();

        ref1.m1();
        ref2.m1();
        ref4.m1();
        ref5.m1();
        //ref6.m1(); Non compila
        ref1.m2();
        ref2.m2();
        ref3.m2();
        ref4.m2();
        //ref6.m2(); Non compila
        ref3.m3();
        //ref5.m3(); Non compila
        ((B)ref1).m3();
        //((D)ref4).m3(); ClassCastException: C cannot be cast to D
        ((D)ref5).m3();
        //((B)ref2).m3(); ClassCastException: D cannot be cast to B
        ((C)ref2).m2(); //OK Casting ref2 to C is redundant
        //((D)ref6).m2(); ClassCastException: C cannot be cast to D
    }

}
