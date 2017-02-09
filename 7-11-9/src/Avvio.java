import java.util.Random;

/**
 * Created by Bea on 08/02/2017.
 */
public class Avvio {
    public static void main(String[] args) {
        Passaggio p = new Passaggio();
        Stop s1 = new Stop(p);
        Stop s2 = new Stop(p);

        s1.start(); s2.start();
        Random r = new Random();
        for (int i=0; i<1000; ++i){
            if (r.nextBoolean()) s1.aggiungiAuto("Auto "+i+" direzione 1");
            else s2.aggiungiAuto("Auto "+i+" direzione 2");
            try{
                Thread.sleep(r.nextInt(100));
            }
            catch (InterruptedException e){}
        }
    }
}
