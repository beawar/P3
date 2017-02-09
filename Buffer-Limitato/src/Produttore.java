/**
 * Created by Bea on 07/02/2017.
 */
public class Produttore extends Thread {
    BoundedBuffer b;
    Produttore(BoundedBuffer buff){
        b=buff;
    }

    @Override
    public void run() {
        int i=0;
        while (i<200){
            synchronized (b){
                try{
                    b.put("Pippo");
                    System.out.println("Messo numero "+i);
                    i++;
                }
                catch (InterruptedException p){
                    System.out.println("Buffer Pieno");
                }
            }
        }
    }
}
