/**
 * Created by Bea on 07/02/2017.
 */
public class Aereo {
    private static int n;
    private int num;
    private String direzione;

    Aereo(String d){
        num = n++;
        direzione = d;
    }

    //ATTENZIONE: invocare questo metodo quando l'aereo è in pista
    public void stampa(){
        System.out.println("aereo num "+num+" "+direzione);
    }
}
