/**
 * Created by Bea on 08/02/2017.
 */
public class RegistroRedditi {
    private int[] redditi;
    boolean sconto = false;
    private int annotati = 0;
    final Object lock_sconto = new Object();

    RegistroRedditi(int dim_famiglia){
        redditi = new int[dim_famiglia];
    }

    public synchronized int riassunto(){
        int sum = 0;
        for (int i=0; i<redditi.length; i++){
            sum += redditi[i];
        }
        return sum;
    }

    public synchronized void setReddito(int r){
        System.out.println("Setting reddito "+r);
        redditi[annotati] = r;
        ++annotati;
        notifyAll();
    }

    public synchronized boolean figliInseriti(int figli){
        if (annotati >= figli){
            return true;
        }
        return false;
    }

    public synchronized int getRedditoFigli(int figli){
        int sum = 0;
        for (int i=0; i<figli; i++){
            sum += redditi[i];
        }
        return sum;
    }
}
