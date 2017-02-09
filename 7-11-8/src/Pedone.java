/**
 * Created by Bea on 08/02/2017.
 */
public class Pedone extends Thread {
    Attraversamento a;
    int distanza;

    Pedone(Attraversamento att, int dist){
        super("Pedone");
        a = att;
        distanza = dist;
    }

    @Override
    public void run() {
        try{
            for (int i=distanza; i>0; i--){
                Thread.sleep((int)Math.random()*80);
            }
            synchronized (a) {
                while (a.occupato[1] && a.occupato[2]) {
                    a.wait();
                }
                a.occupa(0);
                Thread.sleep(1);
                a.libera(0);
                a.notifyAll();
            }
                System.out.println("Pedone e' passato ");
        }
        catch (InterruptedException e){}
        catch (Investito e){
            e.info();
        }
    }
}
