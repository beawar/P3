/**
 * Created by Bea on 07/02/2017.
 */
public class Persona extends Thread{
    private String nome;
    private Viaggio viaggio;

    public Persona(String n, Viaggio v){
        nome = n;
        viaggio = v;
    }

    @Override
    public void run() {
        if (viaggio.Prenota(this)){
            System.out.println("Viaggio di "+ this +" confermato per "+viaggio.getDestinazione());
        }
        else {
            try {
                synchronized (this){
                    System.out.println(this +" è in attesa");
                    wait();
                }
            }
            catch (InterruptedException e){}
            if (viaggio.conferma()){
                System.out.println("Viaggio di "+ this +" confermato dopo attesa per "+viaggio.getDestinazione());
            }
            else
                System.out.println("Viaggio di "+ this +" annullato per "+viaggio.getDestinazione());
        }
    }

    @Override
    public String toString() {
        return nome;
    }
}
