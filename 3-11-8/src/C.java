/**
 * Created by Bea on 06/02/2017.
 */
public class C extends A {
    public void m1(){
        print("C.m1");
    }

    public void m2(){
        print("C.m2");
        m1();
    }
}
