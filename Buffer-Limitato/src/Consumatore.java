/**
 * Created by Bea on 07/02/2017.
 */
public class Consumatore extends Thread{
    BoundedBuffer b;
    Consumatore(BoundedBuffer b){
        this.b = b;
    }

    @Override
    public void run() {
        int i = 0;
        while (i<200){
            synchronized (b){
                try {
                    System.out.println("preso "+b.take()+" numero "+i);
                    i++;
                }
                catch (InterruptedException v){
                    System.out.println("buffer vuoto");
                }
            }
        }
    }
}
