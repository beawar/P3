/**
 * Created by Bea on 06/02/2017.
 */
public class D extends B implements X {
    @Override
    public void f() {
        System.out.println("D.f()");
    }

    @Override
    public void g() {
        System.out.println("D.g()");
    }

    public void h(){
        System.out.println("D.h()");
    }

    public static void f(X r, Y s){
        if (r instanceof Y){
            Y y = (Y)r;
            y.g();
        }
        if (s instanceof B)
            s.g();
    }
}
