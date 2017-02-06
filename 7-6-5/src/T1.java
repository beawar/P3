/**
 * Created by Bea on 06/02/2017.
 */
public class T1 extends Thread {
    private B b;
    private C c;
    public T1(B y, C z){
        b=y;
        c=z;
    }

    @Override
    public void run() {
        b.m(c);
        c.m(b);
        System.out.println("Terminazione T1");
    }
}
