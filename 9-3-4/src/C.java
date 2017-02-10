import java.io.Serializable;

/**
 * Created by Bea on 10/02/2017.
 */
public class C implements Serializable {
    protected String s = "vuoto";

    public void f(){ s= "GIALLO";}
    public void g(){ s= "VERDE";}

    @Override
    public String toString() {
        return s;
    }

    public static class E{
        public static void foo1(C c){
            c.s="FOO";
        }
        public static void foo2(C c1, C c2){
            c1 = c2;
        }
    }
}
