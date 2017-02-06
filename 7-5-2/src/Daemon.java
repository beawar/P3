/**
 * Created by Bea on 06/02/2017.
 */
public class Daemon extends Thread {
    public int i = 0;
    public Daemon(){
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true){
            ++i;
            if (i>10000000)
                i = 0;
        }
    }
}
