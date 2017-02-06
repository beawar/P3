/**
 * Created by Bea on 06/02/2017.
 */
public class PingPong extends Thread {
    private String parola;
    private int delay;

    public PingPong(String s, int d){
        parola = s;
        delay = d;
    }

    public void run(){
        try{
            for (;;){
                System.out.println(parola + " ");
                Thread.sleep(delay);
            }
        }
        catch (InterruptedException e){
            return;
        }
    }

    public static void main(String[] args) {
        Thread t1 = new PingPong("ping", 33);
        t1.start();
        Thread t2 = new PingPong("PONG", 33);
        t2.start();
    }
}
