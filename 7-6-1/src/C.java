/**
 * Created by Bea on 06/02/2017.
 */
public class C {
    public int i = 0;
    public synchronized void m(){
        for (int k=0; k<100000; k++) i++;
        for (int k=0; k<100000; k++) i--;
    }
    public synchronized int getI(){
        return i;
    }
}
