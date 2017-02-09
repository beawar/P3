/**
 * Created by Bea on 08/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        RegistroRedditi registroRedditi = new RegistroRedditi(6);
        Genitore g1 = new Genitore(4);
        Genitore g2 = new Genitore(4);
        Figlio f1 = new Figlio();
        Figlio f2 = new Figlio();
        Figlio f3 = new Figlio();
        Figlio f4 = new Figlio();

        g1.setRr(registroRedditi);
        g2.setRr(registroRedditi);
        f1.setRr(registroRedditi);
        f2.setRr(registroRedditi);
        f3.setRr(registroRedditi);
        f4.setRr(registroRedditi);

        g1.start();
        g2.start();
        f1.start();
        f2.start();
        f3.start();
        f4.start();

        try {
            g1.join();
            g2.join();
        }
        catch (InterruptedException e){}

        System.out.println(registroRedditi.riassunto());
    }
}
