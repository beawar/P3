/**
 * Created by Bea on 07/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        NumberRange n1 = new NumberRange();
        Thread t1 = new Thread(() -> {
            try {
                    n1.setUpper(70);
                    n1.setLower(1);
                }catch (Exception e){
                    System.out.println("Eccezione");
                }
                System.out.println("T1: "+n1.isInRange(50));
            });

        Thread t2 = new Thread(() -> {
                try {
                    n1.setUpper(60);
                    n1.setLower(50);
                }catch (Exception e){
                    System.out.println("Eccezione");
                }
            System.out.println("T2: "+ n1.isInRange(80));
            });

        t1.start(); t2.start();
    }
}
