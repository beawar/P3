/**
 * Created by Bea on 08/02/2017.
 */
public class Figlio extends MembroFamiglia {
    @Override
    public void run() {
            System.out.println("figlio");

                getRr().setReddito((int) (Math.random() * 1000));

            System.out.println("a");
    }

}
