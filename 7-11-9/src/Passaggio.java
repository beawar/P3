/**
 * Created by Bea on 08/02/2017.
 */
public class Passaggio {
    private boolean libero = true;

    public synchronized void occupa(){
        while (!libero){
            try {
                wait();
            }
            catch (InterruptedException e){}
        }

        libero = false;
        System.out.println("occupa");
    }

    public synchronized void libera(){
        libero = true;
        System.out.println("libera");
        notifyAll();
    }
}
