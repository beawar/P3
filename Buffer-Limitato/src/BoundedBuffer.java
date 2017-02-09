/**
 * Created by Bea on 07/02/2017.
 */
public class BoundedBuffer {
    final Object[] items = new Object[100];
    int count, putptr, takeptr;

    public synchronized void put(Object o) throws InterruptedException{
        while (count == items.length){
            System.out.println("Attendo, buffer pieno");
            wait();
        }
        items[putptr] = o;
        putptr++;
        if (putptr == items.length)
            putptr = 0;
        count++;
        notify();
    }

    public synchronized Object take() throws InterruptedException{
        while (count == 0){
            System.out.println("Attendo, buffer vuoto");
            wait();
        }
            Object o = items[takeptr];
            takeptr++;
            if (takeptr==items.length){
                takeptr=0;
            }
            count--;
            notify();
            return o;
    }
}
