/**
 * Created by Bea on 07/02/2017.
 */
public class GeneraArrivi extends Thread{
    private Controllore contr;
    GeneraArrivi(Controllore c){
        super("GeneraArrivi");
        contr = c;
    }

    @Override
    public void run() {
        while (true){
            contr.add_arrivi(new Aereo("in arrivo"));
            try {
                sleep(200);
            }
            catch (InterruptedException e){}
        }
    }
}
