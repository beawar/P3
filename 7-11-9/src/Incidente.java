/**
 * Created by Bea on 08/02/2017.
 */
public class Incidente extends Exception {
    private boolean direzione;
    Incidente(boolean direzione){
        this.direzione = direzione;
    }

    void info(){
        if (direzione)
            System.out.println("INCIDENTE nella direzione 1");
        else
            System.out.println("INCIDENTE nella direzione 0");
    }
}
