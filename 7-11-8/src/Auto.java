/**
 * Created by Bea on 08/02/2017.
 */
public class Auto extends Thread{
    Attraversamento a;
    int direzione; //1 da sinistra, 2 da destra
    int distanza;

    Auto(Attraversamento att, int dir, int dist, String nome){
        super(nome);
        a=att;
        direzione = dir;
        distanza = dist;
    }

    @Override
    public void run() {
        try {
            for (int i = distanza; i>0; i--){
                Thread.sleep((int)(Math.random()*20));
            }
            synchronized (a) {
                while (a.occupato[1] && a.occupato[direzione]){
                    a.wait();
                }
                a.occupa(direzione);
                Thread.sleep(1);
                a.libera(direzione);
                a.notifyAll();
            }
            System.out.println(getName()+" e' passato ");
        }
        catch (InterruptedException e){}
        catch (Investito e){
            e.info();
        }
    }
}
