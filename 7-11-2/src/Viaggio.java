import java.util.concurrent.Callable;

/**
 * Created by Bea on 07/02/2017.
 */
public class Viaggio {
    private String destinazione;
    private int partecipanti;
    private Persona[] iscritti;
    private int count = 0;

    public Viaggio(String destinazione, int partecipanti){
        this.destinazione = destinazione;
        this.partecipanti = partecipanti;
        iscritti = new Persona[partecipanti];
    }

    public boolean Prenota (Persona p){
        if (count == iscritti.length){
            Persona[] temp = iscritti.clone();
            iscritti = new Persona[count*2];
            for (int i=0; i<count; i++){
                iscritti[i] = temp[i];
            }
        }
        iscritti[count] = p;
        count++;
        if (count < partecipanti){
            return false;
        }
        else {
            new Thread(() -> {
                for (int i = 0; i<count-2; ++i){
                    synchronized (iscritti[i]) {
                        iscritti[i].notify();
                    }
                }
            }).start();
            return true;
        }
    }

    public void chiudi(){
        if (count < partecipanti){
            for (int i = 0; i<count; ++i){
                synchronized (iscritti[i]) {
                    iscritti[i].notify();
                }
            }
        }
        else {
            for (int i=0; i<count; ++i)
                System.out.println(iscritti[i]);
        }
    }

    public boolean conferma() {
        return count >= partecipanti;
    }

    public String getDestinazione() {
        return destinazione;
    }
}
