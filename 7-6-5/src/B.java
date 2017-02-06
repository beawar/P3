/**
 * Created by Bea on 06/02/2017.
 */
public class B {
    public synchronized void m(C c){
        for (int k=0; k<1000000000; k++);
        c.m(this);
    }
}
