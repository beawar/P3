/**
 * Created by Bea on 05/02/2017.
 */
public class E extends D {
    int k = D.print("non static E.k");
    E(){
        D.print("k = " + k);
    }
    static int x2 = D.print("static E.x2");

    public static void main(String[] args) {
        D.print("invocazione di E()");
        E e = new E();
    }
}
