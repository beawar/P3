/**
 * Created by Bea on 07/02/2017.
 */
public class GeneraPartenze extends Thread {
    private Controllore contr;
    GeneraPartenze(Controllore c){
        super("GeneraPartenze");
        contr = c;
    }

    @Override
    public void run() {
        while (true){
            contr.add_partenze(new Aereo("in partenza"));
            try{
                sleep(200);
            }
            catch (InterruptedException e){}
        }
    }
}
