/**
 * Created by Bea on 07/02/2017.
 */
public class T1 extends Thread {
    int i = 0;
    T2 t2;

    T1(T2 t2){
        this.t2 = t2;
    }

    @Override
    public void run() {
        while (i < 10000){
            synchronized (t2){
                i++;
                if (i==2000){
                    t2.sospendi = true;
                }
                if (i==6000){
                    t2.sospendi = false;
                    t2.notify();
                }
            }
            try {
                Thread.sleep((int)Math.random()*80);
            }
            catch (InterruptedException e){
                System.out.println("Eccezione");
            }
        }
    }
}
