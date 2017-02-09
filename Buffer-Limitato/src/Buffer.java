/**
 * Created by Bea on 07/02/2017.
 */
public class Buffer {
    public static void main(String[] args) {
        BoundedBuffer buffer = new BoundedBuffer();
        Produttore produttore = new Produttore(buffer);
        Consumatore consumatore = new Consumatore(buffer);
        produttore.start();
        consumatore.start();
    }
}
