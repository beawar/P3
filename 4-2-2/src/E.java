/**
 * Created by Bea on 06/02/2017.
 */
public class E {
    static void f(A ref){
        ref.m();
    }
    static void g(A[] a){
        for (int i = 0; i < a.length; i++){
            f(a[i]);
        }
    }

    public static void main(String[] args) {
        A[] a = new A[4];
        a[0] = new B();
        a[1] = new C();
        a[2] = new D();
        a[3] = new C();
        g(a);
    }
}
