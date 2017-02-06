/**
 * Created by Bea on 06/02/2017.
 */
public class C {
    public synchronized void m(B b){
        for (int k=0; k<100000; k++);
        b.m(this);
    }
}
