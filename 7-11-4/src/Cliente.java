/**
 * Created by Bea on 07/02/2017.
 */
public class Cliente extends Thread{
    private TavolaCalda mensa;
    private static int nC;
    private int numero;

    // l'ordine di arrivo dei clienti corrisponde
    // al numero assegnato dal costruttore
    Cliente (TavolaCalda m){
        mensa = m;
        numero = nC++;
    }

    public void run(){
        mensa.prendi_primo(numero);
        mensa.prendi_secondo(numero);
        mensa.paga(this);
    }

    // metodo invocato dal cassiere della tavola calda
    public void pagamento(){
        System.out.println(numero+" ha pagato");
    }

}
