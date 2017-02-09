/**
 * Created by Bea on 08/02/2017.
 */
public class Attraversamento {
    boolean[] occupato = new boolean[3];
    //occupato[0] -> pedone sta attraversando
    //occupato[1] -> auto da sinistra sta attraversando
    //occupato[2] -> auto da destra sta attraversando

    Attraversamento(){
        for (boolean b : occupato){
            b = false;
        }
    }

    public synchronized void occupa(int chi) throws Investito{
        occupato[chi] = true;

        System.out.println(Thread.currentThread().getName()+
        " e' su incrocio");

        if (chi==0 && occupato[1]) throw new Investito(0, 1);
        if (chi==0 && occupato[2]) throw new Investito(0,2);
        if (occupato[0] && chi!=0) throw new Investito(chi, 0);
    }

    public synchronized void libera(int chi){
        occupato[chi] = false;
    }
}
