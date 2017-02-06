/**
 * Created by Bea on 06/02/2017.
 */
public class T2 extends Thread {
    private B b;
    private C c;
    public T2(B y, C z){
        b=y;
        c=z;
    }

    @Override
    public void run() {
        c.m(b);
        b.m(c);
        System.out.println("Terminazione T2");
    }
}
