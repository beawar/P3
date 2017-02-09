import java.util.Random;

/**
 * Created by Bea on 08/02/2017.
 */
public class IncrocioPulito {
    public static void main(String[] args) {
        Attraversamento a = new Attraversamento();

        Auto auto1 = new Auto(a, 1, 10, "Auto da sinistra");
        Auto auto2 = new Auto(a, 2, 5, "Auto da destra");
        Pedone pedone = new Pedone(a, 8);
        Random r = new Random();

        auto1.start(); auto2.start(); pedone.start();
        for (int i=0; i<50; ++i){
            int d;
            String n;
            if (r.nextBoolean()){
                d = 1;
                n = "Auto "+i+" da sinistra";
            }
            else {
                d = 0;
                n = "Auto "+i+" da destra";
            }
            new Auto(a, d, r.nextInt(10), n).start();
            new Pedone(a, r.nextInt(10)).start();
        }
    }
}
