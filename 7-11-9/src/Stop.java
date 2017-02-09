import java.util.Vector;

/**
 * Created by Bea on 08/02/2017.
 */
public class Stop extends Thread {
    Vector<String> auto = new Vector<String>();
    Passaggio passaggio;
    static final Object verde = new Object();

    Stop(Passaggio p){
        passaggio = p;
    }
    @Override
    public void run() {
        try {
           sleep(500);
            while (true) {
                synchronized (passaggio) {
                        while (auto.isEmpty()) {
                            sleep(200);
                            passaggio.wait();
                        }

                        while (!auto.isEmpty()) {
                            passaggio.occupa();
                            sleep(100);
                            passaggio.libera();
                            System.out.println(auto.remove(0) + " in transito");
                        }
                    System.out.println("Coda liberata");
                    }
            }
        }
        catch (InterruptedException e){}
    }

    public void aggiungiAuto(String a){
        synchronized (passaggio){
            auto.add(a);
            passaggio.notifyAll();
        }
    }

}
