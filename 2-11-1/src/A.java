/**
 * Created by Bea on 05/02/2017.
 */
public class A {
    public static void m(Object[] a, Object[] b){
        Object t = a[0];
        a[0] = b[0];
        b[0] = t;
    }

    public static void main(String[] args) {
        String[] x = {new String("a"), new String("b")};
        String[] y = {new String("c"), new String("d")};
        m(x, y);
        System.out.println(x[0] + " " + x[1]);
        System.out.println(y[0] + " " + y[1]);
    }
}
